package models;

import models.bamboo.BambooServerConfiguration;
import models.jira.JiraServerConfiguration;
import play.Play;

/**
 * A ServerConfiguration Factory based on play configuration mechanism
 */
public class PlayBasedServerConfiguration {

    public static final String JIRA_URL = "jira.url";
    public static final String JIRA_USERNAME = "jira.username";
    public static final String JIRA_PASSWORD = "jira.password";
    public static final String BAMBOO_URL = "bamboo.url";
    public static final String BAMBOO_USERNAME = "bamboo.username";
    public static final String BAMBOO_PASSWORD = "bamboo.password";

    private PlayBasedServerConfiguration() {
    }

    public static JiraServerConfiguration newJiraServerConfiguration() {
        JiraServerConfiguration.Builder builder = new JiraServerConfiguration.Builder();

        builder.withUrl(Play.application().configuration().getString(JIRA_URL)).
                withUserName(Play.application().configuration().getString(JIRA_USERNAME)).
                withPassword(Play.application().configuration().getString(JIRA_PASSWORD)).build();

        return builder.build();
    }

    public static BambooServerConfiguration newBambooServerConfiguration() {
        BambooServerConfiguration.Builder builder = new BambooServerConfiguration.Builder();
        builder.withUrl(Play.application().configuration().getString(BAMBOO_URL)).
                withUserName(Play.application().configuration().getString(BAMBOO_USERNAME)).
                withPassword(Play.application().configuration().getString(BAMBOO_PASSWORD)).build();

        return builder.build();

    }
}
