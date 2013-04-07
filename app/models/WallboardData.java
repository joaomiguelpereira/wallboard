package models;

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
    public WallboardData(List<ScrumBoard> scrumBoards) {
        this.scrumBoards = scrumBoards;
    }

    public List<ScrumBoard> getScrumBoards() {
        return scrumBoards;
    }
}
