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

import models.bamboo.BambooBuildPlan;
import models.jira.ScrumBoard;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class WallboardData {
    private List<ScrumBoard> scrumBoards;
    private List<BambooBuildPlan> bambooBuildPlan;

    public WallboardData(List<ScrumBoard> scrumBoards, List<BambooBuildPlan> plans) {
        this.bambooBuildPlan = plans;
        this.scrumBoards = scrumBoards;
    }

    public List<ScrumBoard> getScrumBoards() {
        return scrumBoards;
    }

    public List<BambooBuildPlan> getBambooBuildPlan() {
        return bambooBuildPlan;
    }
}
