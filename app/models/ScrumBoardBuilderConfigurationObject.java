package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/7/13
 * Time: 12:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScrumBoardBuilderConfigurationObject {

    private JiraServer jiraServer;

    public JiraServer getJiraServer() {
        return jiraServer;
    }


    public static class Builder {

        private ScrumBoardBuilderConfigurationObject object = new ScrumBoardBuilderConfigurationObject();

        public Builder with(JiraServer jiraServer) {
            object.jiraServer = jiraServer;
            return this;
        }

        public ScrumBoardBuilderConfigurationObject build() {
            return object;
        }

    }

}
