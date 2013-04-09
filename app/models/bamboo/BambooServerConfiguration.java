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

import models.BasicServerConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/8/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class BambooServerConfiguration extends BasicServerConfiguration {

    public static class Builder extends BasicServerConfiguration.Builder<BambooServerConfiguration> {

        BambooServerConfiguration configObject = new BambooServerConfiguration();

        @Override
        protected BasicServerConfiguration getConfigObject() {
            return configObject;
        }

        @Override
        public BambooServerConfiguration build() {
            return configObject;
        }
    }
}
