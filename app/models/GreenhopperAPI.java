package models;

import java.util.HashMap;
import java.util.Map;

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
        return jiraServer.execute(new SprintReportUrlBuilder(sprintReportUrl, boardId, sprintId));
    }

    public String getSprintsForBoard(String id) {
        return jiraServer.execute(new UrlBuilder(sprintsUrl + id));
    }


    public String getBoard(String id) {
        return jiraServer.execute(new UrlBuilder(rapidViewUrl + id));
    }


    private class SprintReportUrlBuilder extends UrlBuilder {

        private String sprintId;

        public SprintReportUrlBuilder(String sprintReportUrl, String boardId, String sprintId) {
            super(sprintReportUrl);
            Map<String, String> parameters = new HashMap<>();
            parameters.put("rapidViewId", boardId);
            parameters.put("sprintId", sprintId);

            super.addParameters(parameters);

        }


    }
}
