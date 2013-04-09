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

import models.UrlBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 09-04-2013
 * Time: 1:03
 * To change this template use File | Settings | File Templates.
 */
public class BambooBuildAPI {

    private static final String BUILT_REST_API = "/rest/api/latest/build/";

    private final BambooServer bambooServer;

    public BambooBuildAPI(BambooServer bambooServer) {
        this.bambooServer = bambooServer;
    }

    public String getBuild(String bambooPlanKey) {
        return bambooServer.execute(new BambooBuildUrlBuilder(bambooServer.getBambooServerUrl(), bambooPlanKey));
    }

    private class BambooBuildUrlBuilder extends UrlBuilder {


        public BambooBuildUrlBuilder(String bambooServerUrl, String bambooPlanKey) {
            super(bambooServerUrl + BUILT_REST_API + bambooPlanKey + ".json");

        }
    }
}
