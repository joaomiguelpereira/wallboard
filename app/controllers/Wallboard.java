package controllers;

import models.*;
import play.cache.Cache;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Wall board main controller
 */
public class Wallboard extends Controller {


    private static List<String> scrumBoardIds = new ArrayList<String>();

    private static String bambooPlanKey = "EFRAME-DEF";

    static {
        scrumBoardIds.add("6");
        scrumBoardIds.add("5");
        scrumBoardIds.add("7");
        scrumBoardIds.add("8");
        scrumBoardIds.add("17");
        scrumBoardIds.add("2");
        scrumBoardIds.add("9");
        scrumBoardIds.add("10");
    }


    public static Result htmlWallboard() {
        return ok(views.html.wallboardAngular.render("title"));

    }

    public static Result wallboard() {


        WallboardData wallBoardData;

        try {
            wallBoardData = getWallBoard();
        } catch (Exception e) {
            return internalServerError(e.getLocalizedMessage());
        }

        return ok(Json.toJson(wallBoardData));
    }

    private static WallboardData getWallBoard() throws Exception {

        if (Cache.get("wallboard") != null) {
            Object cachedObject = Cache.get("wallboard");
            if (cachedObject instanceof WallboardData) {
                play.Logger.debug("Returning cached instance of Wallboard Data");
                return (WallboardData) cachedObject;
            }
        }


        WallboardData wallboardData = buildWallboardData();
        Cache.set("wallboard", wallboardData, 60 * 10);
        return wallboardData;

    }

    private static WallboardData buildWallboardData() throws Exception {


        //Create a JiraServer Configuration
        JiraServerConfiguration jiraServerConfiguration = PlayBasedServerConfiguration.newJiraServerConfiguration();

        //Create a BambooServer COnfiguration
        BambooServerConfiguration bambooServerConfiguration = PlayBasedServerConfiguration.newBambooServerConfiguration();


        BambooServer bambooServer = BambooServerFactory.create(bambooServerConfiguration);
        BambooBuild bambooBuild = new BambooBuildBuilder().withPlanKey(bambooPlanKey).with(bambooServer).build();

        JiraServer jiraServer = new JiraServerFactory().create(jiraServerConfiguration);



        List<ScrumBoard> scrumBoards;

        try {
            scrumBoards = new ScrumBoardBuilder().withIds(scrumBoardIds).with(jiraServer).build();
        } catch (ScrumBoardException e) {
            play.Logger.error("Error", e);
            throw new Exception(e);
        }

        return new WallboardData(scrumBoards);
    }

}

