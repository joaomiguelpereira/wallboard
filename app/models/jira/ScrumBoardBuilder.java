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
