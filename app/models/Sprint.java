package models;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 4:00
 * To change this template use File | Settings | File Templates.
 */
public class Sprint {

    private String id;
    private String name;
    private Boolean closed;
    private String parentBoardId;
    //TODO: CHange to dates
    private String startDate;
    private String endDate;
    private String completeDate;

    private List<JiraIssue> completedIssues;

    private List<JiraIssue> incompletedIssues;
    private List<JiraIssue> puntedIssues;

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

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public void setParentBoardId(String parentBoardId) {
        this.parentBoardId = parentBoardId;
    }

    public String getParentBoardId() {
        return parentBoardId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public List<JiraIssue> getCompletedIssues() {
        return completedIssues;
    }

    public void setCompletedIssues(List<JiraIssue> completedIssues) {
        this.completedIssues = completedIssues;
    }

    public List<JiraIssue> getIncompletedIssues() {
        return incompletedIssues;
    }

    public void setIncompletedIssues(List<JiraIssue> incompletedIssues) {
        this.incompletedIssues = incompletedIssues;
    }

    public List<JiraIssue> getPuntedIssues() {
        return puntedIssues;
    }

    public void setPuntedIssues(List<JiraIssue> puntedIssues) {
        this.puntedIssues = puntedIssues;
    }

}
