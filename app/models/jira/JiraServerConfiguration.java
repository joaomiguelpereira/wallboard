package models.jira;

import models.BasicServerConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class JiraServerConfiguration extends BasicServerConfiguration {

    public static class Builder extends BasicServerConfiguration.Builder<JiraServerConfiguration> {

        private JiraServerConfiguration config = new JiraServerConfiguration();

        @Override
        protected JiraServerConfiguration getConfigObject() {
            return config;
        }

        @Override
        public JiraServerConfiguration build() {
            return config;
        }
    }
}
