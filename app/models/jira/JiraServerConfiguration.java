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
