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
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Assembler for a BambooBUild
 */
public class BambooBuildPlanAssembler {

    private BambooServer bambooServer;

    public BambooBuildPlanAssembler(BambooServer bambooServer) {
        this.bambooServer = bambooServer;
    }

    public BambooBuildPlan assemble(String bambooPlanKey) throws AssemblingException {
        String json = bambooServer.bambooBuildAPI().getBuild(bambooPlanKey);
        List<BambooBuild> builds;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode buildNode;

        try {
            buildNode = mapper.readTree(json).get("builds");
        } catch (IOException e) {
            throw new AssemblingException(e);
        }

        try {
            builds = mapper.readValue(buildNode,
                    mapper.getTypeFactory().constructCollectionType(List.class, BambooBuild.class)
            );

        } catch (IOException e) {
            throw new AssemblingException(e);
        }
        BambooBuildPlan plan = new BambooBuildPlan();
        plan.setBuilds(builds);

        return plan;
    }

}
