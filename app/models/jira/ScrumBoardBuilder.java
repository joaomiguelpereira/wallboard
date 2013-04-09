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

import models.AssemblingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/7/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScrumBoardBuilder {


    private List<String> boardIds;


    private JiraServer jiraServer;

    public ScrumBoardBuilder withIds(String[] scrumBoardIds) {
        boardIds = Arrays.asList(scrumBoardIds);
        return this;
    }

    public ScrumBoardBuilder with(JiraServer jiraServer) {
        this.jiraServer = jiraServer;
        return this;

    }

    public List<ScrumBoard> build() throws ScrumBoardBuilderException {


        if (this.jiraServer == null || this.boardIds == null) {
            throw new ScrumBoardBuilderException("Jira Server and board ids required");
        }

        List<ScrumBoard> boards = new ArrayList<ScrumBoard>();
        ScrumBoardAssembler assembler = new ScrumBoardAssembler(jiraServer);

        for (String id : this.boardIds) {
            ScrumBoard scrumBoard;
            try {
                scrumBoard = assembler.assemble(id);
            } catch (AssemblingException e) {
                throw new ScrumBoardBuilderException(e);
            }
            boards.add(scrumBoard);

        }
        //Get all rapid views

        return boards;

    }
}
