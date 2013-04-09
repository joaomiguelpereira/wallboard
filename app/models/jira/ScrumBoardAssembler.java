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
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Assembler of a Scrum Board. Todo: Refactor sub assemblers
 */
public class ScrumBoardAssembler {
    public static final String SPRINTS_PROPERTY_NAME = "sprints";
    private final JiraServer jiraServer;


    public ScrumBoardAssembler(JiraServer jiraServer) {
        this.jiraServer = jiraServer;
    }

    public ScrumBoard assemble(String id) throws AssemblingException {
        //Get Sprints
        ScrumBoard scrumBoard = assembleScrumBoard(id);
        assembleSprints(scrumBoard);


        return scrumBoard;
    }

    private ScrumBoard assembleScrumBoard(String id) throws AssemblingException {
        String json = jiraServer.greenhopperApi().getBoard(id);
        ObjectMapper mapper = new ObjectMapper();
        ScrumBoard board;
        try {
            board = mapper.readValue(json, ScrumBoard.class);
        } catch (IOException e) {
            throw new AssemblingException(e);
        }
        return board;
    }

    private void assembleSprints(ScrumBoard board) throws AssemblingException {

        String json = jiraServer.greenhopperApi().getSprintsForBoard(board.getId());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(json);
        } catch (IOException e) {
            throw new AssemblingException(e);
        }
        JsonNode sprintsNode = jsonNode.get(SPRINTS_PROPERTY_NAME);
        List<Sprint> sprints;
        try {
            sprints = mapper.readValue(sprintsNode, mapper.getTypeFactory().constructCollectionType(List.class, Sprint.class));
        } catch (IOException e) {
            throw new AssemblingException(e);
        }
        for (Sprint sprint : sprints) {
            board.addSprint(sprint);
            assembleIssues(sprint);
        }
    }

    private void assembleIssues(Sprint sprint) throws AssemblingException {
        String json = jiraServer.greenhopperApi().getSprintReport(sprint.getParentBoardId(), sprint.getId());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(json);
        } catch (IOException e) {
            throw new AssemblingException(e);
        }

        //Enrich sprint info
        JsonNode sprintNode = jsonNode.get("sprint");

        sprint.setStartDate(sprintNode.get("startDate").asText());
        sprint.setEndDate(sprintNode.get("endDate").asText());
        sprint.setCompleteDate(sprintNode.get("completeDate").asText());


        JsonNode contentsNode = jsonNode.get("contents");

        List<JiraIssue> completedIssues;
        List<JiraIssue> incompletedIssues;
        List<JiraIssue> puntedIssues;

        try {
            completedIssues = mapper.
                    readValue(contentsNode.get("completedIssues"),
                            mapper.getTypeFactory().constructCollectionType(List.class, JiraIssue.class)
                    );

            incompletedIssues = mapper.
                    readValue(contentsNode.get("incompletedIssues"),
                            mapper.getTypeFactory().constructCollectionType(List.class, JiraIssue.class)
                    );
            puntedIssues = mapper.
                    readValue(contentsNode.get("puntedIssues"),
                            mapper.getTypeFactory().constructCollectionType(List.class, JiraIssue.class)
                    );


        } catch (IOException e) {
            throw new AssemblingException(e);
        }

        sprint.setCompletedIssues(completedIssues);
        sprint.setIncompletedIssues(incompletedIssues);
        sprint.setPuntedIssues(puntedIssues);
    }
}
