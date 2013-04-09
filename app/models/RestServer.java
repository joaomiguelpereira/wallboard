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

import play.libs.F;
import play.libs.WS;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 09-04-2013
 * Time: 1:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class RestServer {


    private UsernamePasswordAuthentication authentication;

    public RestServer(UsernamePasswordAuthentication authentication) {
        this.authentication = authentication;
    }

    public String execute(UrlBuilder urlBuilder) {


        //Abstract this code out to a Rest Server, for example

        play.Logger.debug("Calling: " + urlBuilder.getUrl());
        WS.WSRequestHolder wsreqHolder = WS.url(urlBuilder.getUrl()).setAuth(authentication.getUserName(), authentication.getPassword());

        urlBuilder.buildRequestQueryString(wsreqHolder);

        F.Promise<WS.Response> promiseOfResult = wsreqHolder.get();

        WS.Response response = promiseOfResult.get(3L, TimeUnit.MINUTES); //block here
        String body = response.getBody();
        play.Logger.debug("Got response " + body);
        return body;

    }
}
