package models.jira;

import models.WallboardException;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/9/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScrumBoardBuilderException extends WallboardException {
    public ScrumBoardBuilderException(String s) {
        super(s);
    }

    public ScrumBoardBuilderException(Throwable throwable) {
        super(throwable);
    }
}
