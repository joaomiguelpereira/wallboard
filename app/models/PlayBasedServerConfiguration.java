package models;

import play.Play;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class PlayBasedServerConfiguration implements ServerConfiguration{

    public static final String JIRA_URL = "jira.url";
    public static final String JIRA_USERNAME = "jira.username";
    public static final String JIRA_PASSWORD = "jira.password";
    private String jiraUrl;
    private String jiraUserName;
    private String jiraPassword;

    private PlayBasedServerConfiguration() {

    }


    public static ServerConfiguration newConfiguration() {
        PlayBasedServerConfiguration configuration = new PlayBasedServerConfiguration();
        configuration.jiraUrl = Play.application().configuration().getString(JIRA_URL);
        configuration.jiraUserName = Play.application().configuration().getString(JIRA_USERNAME);
        configuration.jiraPassword = Play.application().configuration().getString(JIRA_PASSWORD);
        return configuration;


    }

    public String getJiraUrl() {
        return jiraUrl;
    }

    public String getJiraUserName() {
        return jiraUserName;
    }

    public String getJiraPassword() {
        return jiraPassword;
    }
}
