package models.bamboo;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/8/13
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class BambooServerFactory {

    public static BambooServer create(BambooServerConfiguration serverConfiguration) {
        return new BambooServer(serverConfiguration);
    }
}
