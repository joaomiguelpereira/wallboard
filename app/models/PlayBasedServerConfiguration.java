/*
 * Copyright (c) 2013 Joao Miguel Pereira
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
