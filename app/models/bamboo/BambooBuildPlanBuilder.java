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

import models.AssemblingException;

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
public class BambooBuildPlanBuilder {

    private List<String> bambooBuildKeys;
    private BambooServer bambooServer;

    public BambooBuildPlanBuilder withPlanKeys(String[] bambooBuildKeys) {
        this.bambooBuildKeys = Arrays.asList(bambooBuildKeys);
        return this;

    }

    public BambooBuildPlanBuilder with(BambooServer bambooServer) {
        this.bambooServer = bambooServer;
        return this;
    }

    public List<BambooBuildPlan> build() throws BambooBuildException {
        if (bambooServer == null || this.bambooBuildKeys == null) {
            throw new BambooBuildException("A bamboo server and bamboo plan keys are required");
        }

        BambooBuildPlanAssembler assembler = new BambooBuildPlanAssembler(bambooServer);

        List<BambooBuildPlan> builds = new ArrayList<>();

        for (String bambooPlanKey : this.bambooBuildKeys) {

            try {
                builds.add(assembler.assemble(bambooPlanKey));
            } catch (AssemblingException e) {
                throw new BambooBuildException(e);
            }
        }

        return builds;
    }
}
