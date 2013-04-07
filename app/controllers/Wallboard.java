package controllers;

import models.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.wallboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Wall board main controller
 */
public class Wallboard extends Controller {


    private static List<String> scrumBoardIds = new ArrayList<>();

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

    public static Result wallboard() {

        BambooBuild build = new BambooBuild();

        //Create a Server Configuration object, holding stuff for Jira, Bamboo, Sonar, Etc
        ServerConfiguration serverConfiguration = PlayBasedServerConfiguration.newConfiguration();


        JiraServer jiraServer;

        try {
            jiraServer = new JiraServerFactory().create(serverConfiguration);
        } catch (JiraServerException e) {
            play.Logger.error("Error: ", e);
            return internalServerError(e.getLocalizedMessage());
        }


        ScrumBoardBuilderConfigurationObject config = new ScrumBoardBuilderConfigurationObject.Builder().with(jiraServer).build();

        List<ScrumBoard> scrumBoards;
        try {
            scrumBoards = new ScrumBoardBuilder().withIds(scrumBoardIds).with(config).build();
        } catch (ScrumBoardException e) {
            play.Logger.error("Error", e);
            return internalServerError(e.toString());
        }

        return ok(Json.toJson(new WallboardData(scrumBoards)));
    }
}

