package models;

import play.Play;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class PlayBasedServerConfiguration implements JiraServerConfiguration, BambooServerConfiguration {

    public static final String JIRA_URL = "jira.url";
    public static final String JIRA_USERNAME = "jira.username";
    public static final String JIRA_PASSWORD = "jira.password";
    public static final String BAMBOO_URL = "bamboo.url";
    public static final String BAMBOO_USERNAME = "bamboo.username";
    public static final String BAMBOO_PASSWORD = "bamboo.password";

    private String jiraUrl;
    private String jiraUserName;
    private String jiraPassword;
    private String bambooUrl;
    private String bambooUserName;
    private String bambooPassword;


    private PlayBasedServerConfiguration() {

    }


    public static JiraServerConfiguration newJiraServerConfiguration() {
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

    public String getBambooUrl() {
        return bambooUrl;
    }

    public String getBambooUserName() {
        return bambooUserName;
    }

    public String getBambooPassword() {
        return bambooPassword;
    }

    public static BambooServerConfiguration newBambooServerConfiguration() {
        PlayBasedServerConfiguration configuration = new PlayBasedServerConfiguration();
        configuration.bambooUrl = Play.application().configuration().getString(BAMBOO_URL);
        configuration.bambooUserName = Play.application().configuration().getString(BAMBOO_USERNAME);
        configuration.bambooPassword = Play.application().configuration().getString(BAMBOO_PASSWORD);

        return configuration;

    }
}
