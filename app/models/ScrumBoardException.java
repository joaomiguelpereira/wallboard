package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 3:53
 * To change this template use File | Settings | File Templates.
 */
public class ScrumBoardException extends Throwable {
    public ScrumBoardException(String s) {
        super(s);
    }

    public ScrumBoardException(Throwable throwable) {
        super(throwable);
    }
}
