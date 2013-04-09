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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/8/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class BambooBuildBuilder {

    private List<String> bambooBuildKeys;
    private BambooServer bambooServer;

    public BambooBuildBuilder withPlanKey(String[] bambooBuildKeys) {
        this.bambooBuildKeys = Arrays.asList(bambooBuildKeys);
        return this;

    }

    public BambooBuildBuilder with(BambooServer bambooServer) {
        this.bambooServer = bambooServer;
        return this;
    }

    public List<BambooBuild> build() throws BambooBuildException {
        if (bambooServer == null || this.bambooBuildKeys == null) {
            throw new BambooBuildException("A bamboo server and bamboo plan keys are required");
        }

        BambooBuildAssembler assembler = new BambooBuildAssembler(bambooServer);

        List<BambooBuild> builds = new ArrayList<>();

        for (String bambooPlanKey : this.bambooBuildKeys) {
            builds.add(assembler.assemble(bambooPlanKey));
        }

        return builds;
    }
}
