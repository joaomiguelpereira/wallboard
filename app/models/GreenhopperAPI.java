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
        return jiraServer.execute(new SprintreportUrlBuilder(sprintReportUrl, boardId, sprintId));
    }

    public String getSprintsForBoard(String id) {
        return jiraServer.execute(new UrlBuilder(sprintsUrl, id));
    }


    public String getBoard(String id) {
        return jiraServer.execute(new UrlBuilder(rapidViewUrl, id));
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
