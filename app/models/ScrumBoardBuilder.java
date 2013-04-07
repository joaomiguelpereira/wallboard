package models;

import java.util.ArrayList;
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


    private ScrumBoardBuilderConfigurationObject configObject;

    public ScrumBoardBuilder withIds(List<String> scrumBoardIds) {
        boardIds = new ArrayList<>(scrumBoardIds);
        return this;
    }

    public ScrumBoardBuilder with(ScrumBoardBuilderConfigurationObject config) {
        this.configObject = config;
        return this;

    }

    public List<ScrumBoard> build() throws ScrumBoardException {

        List<ScrumBoard> boards = new ArrayList<>();

        if (this.configObject == null || this.boardIds == null) {
            throw new ScrumBoardException("config and board ids required");
        }

        ScrumBoardAssembler assembler = new ScrumBoardAssembler(configObject.getJiraServer());

        for (String id : this.boardIds) {
            ScrumBoard scrumBoard;
            try {
                scrumBoard = assembler.assemble(id);
            } catch (AssemblingException e) {
                throw new ScrumBoardException(e);
            }
            boards.add(scrumBoard);

        }
        //Get all rapid views

        return boards;

    }
}
