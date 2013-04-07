package models;

import play.Logger;
import play.libs.F;
import play.libs.WS;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/7/13
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class GreenhopperAPI {


    private final JiraServer jiraServer;

    private final String REST_API = "/rest/greenhopper/1.0/";
    private final String baseURL;
    private final String rapidViewUrl;
    private final String sprintsUrl;
    private final String sprintReportUrl;

    //rapid/charts/sprintreport?rapidViewId=6&sprintId=1

    public GreenhopperAPI(JiraServer jiraServer) {

        this.baseURL = jiraServer.getServerURL();
        this.jiraServer = jiraServer;
        rapidViewUrl = baseURL + REST_API + "rapidview/";
        sprintsUrl = baseURL + REST_API + "sprints/";
        sprintReportUrl = baseURL + REST_API + "rapid/charts/sprintreport";

    }


    public String getSprintReport(String boardId, String sprintId) {
        return jsonContentsOf(new SprintreportUrlBuilder(sprintReportUrl, boardId, sprintId));
    }

    public String getSprintsForBoard(String id) {
        return jsonContentsOf(new UrlBuilder(sprintsUrl, id));
    }


    public String getBoard(String id) {
        return jsonContentsOf(new UrlBuilder(rapidViewUrl, id));
    }

    private String jsonContentsOf(UrlBuilder urlBuilder) {

        String userName = jiraServer.getUserName();
        String password = jiraServer.getPassword();


       play.Logger.debug("Calling: "+urlBuilder.getUrl());
        WS.WSRequestHolder wsreqHolder = WS.url(urlBuilder.getUrl()).setAuth(userName, password);

        urlBuilder.setParameters(wsreqHolder);

        F.Promise<WS.Response> promiseOfResult = wsreqHolder.get();

        WS.Response response = promiseOfResult.get(3L, TimeUnit.MINUTES); //block here

        //play.Logger.debug("Contents: " + response.getBody());

        return response.getBody();

    }

    private class UrlBuilder {
        protected String boardId;
        protected String url;

        public UrlBuilder(String url, String id) {
            this.url = url ;
            this.boardId = id;
        }


        public UrlBuilder() {
        }

        public String getUrl() {
            return this.url+this.boardId;
        }


        public void setParameters(WS.WSRequestHolder wsreqHolder) {

        }
    }

    private class SprintreportUrlBuilder extends UrlBuilder {

        private String sprintId;

        public SprintreportUrlBuilder(String sprintReportUrl, String boardId, String sprintId) {
            super(sprintReportUrl,boardId);
            this.sprintId = sprintId;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public void setParameters(WS.WSRequestHolder wsreqHolder) {

            wsreqHolder.setQueryParameter("rapidViewId",boardId);
            wsreqHolder.setQueryParameter("sprintId",sprintId);


        }
    }
}
