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

package models.bamboo;

import models.RestServer;
import models.UsernamePasswordAuthentication;

/**
 * A simple Bamboo REST Server.
 */

public class BambooServer extends RestServer {

    private BambooBuildAPI bambooBuildAPI;
    private BambooServerConfiguration configuration;

    public BambooServer(BambooServerConfiguration serverConfiguration) {
        super(new UsernamePasswordAuthentication(serverConfiguration.getUserName(), serverConfiguration.getPassword()));
        bambooBuildAPI = new BambooBuildAPI(this);
        this.configuration = serverConfiguration;
    }

    public BambooBuildAPI bambooBuildAPI() {
        return this.bambooBuildAPI;
    }

    public String getBambooServerUrl() {
        return this.configuration.getUrl();
    }
}
