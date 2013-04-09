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

import models.RestServer;
import models.UsernamePasswordAuthentication;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/7/13
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class JiraServer extends RestServer {

    private final String serverURL;
    private final GreenhopperAPI greenhopperAPI;

    public JiraServer(JiraServerConfiguration serverConfiguration) {
        super(new UsernamePasswordAuthentication(serverConfiguration.getUserName(), serverConfiguration.getPassword()));

        this.serverURL = serverConfiguration.getUrl();
        this.greenhopperAPI = new GreenhopperAPI(this);
    }

    public GreenhopperAPI greenhopperApi() {
        return greenhopperAPI;
    }

    public String getServerURL() {
        return serverURL;
    }

}
