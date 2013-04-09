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

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/9/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicServerConfiguration {

    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return this.url;

    }

    public String getUserName() {
        return this.userName;

    }

    public String getPassword() {
        return password;
    }

    public abstract static class Builder<T extends BasicServerConfiguration> {

        public Builder withUrl(String jiraUrl) {
            getConfigObject().url = jiraUrl;
            return this;

        }

        public Builder withUserName(String userName) {
            getConfigObject().userName = userName;
            return this;
        }

        public Builder withPassword(String password) {
            getConfigObject().password = password;
            return this;
        }

        protected abstract BasicServerConfiguration getConfigObject();

        public abstract T build();


    }
}
