package models.jira;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/7/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScrumBoard {
    private List<Sprint> sprints = new ArrayList<Sprint>();
    private String id;
    private String name;
    private Boolean canEdit;
    private Boolean sprintSupportEnabled;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getSprintSupportEnabled() {
        return sprintSupportEnabled;
    }

    public void setSprintSupportEnabled(Boolean sprintSupportEnabled) {
        this.sprintSupportEnabled = sprintSupportEnabled;
    }

    public void addSprint(Sprint sprint) {
        sprint.setParentBoardId(this.id);
        this.sprints.add(sprint);
    }

    public List<Sprint> getSprints() {
        return Collections.unmodifiableList(this.sprints);
    }
}
