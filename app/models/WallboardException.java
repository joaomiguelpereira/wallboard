package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 3:53
 * To change this template use File | Settings | File Templates.
 */
public class WallboardException extends Throwable {
    public WallboardException(String s) {
        super(s);
    }

    public WallboardException(Throwable throwable) {
        super(throwable);
    }
}
