package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 09-04-2013
 * Time: 1:03
 * To change this template use File | Settings | File Templates.
 */
public class BambooBuildAPI {

    private final BambooServer bambooServer;

    public BambooBuildAPI(BambooServer bambooServer) {
        this.bambooServer = bambooServer;
    }

    public String getBuild(String bambooPlanKey) {
        return bambooServer.execute(new BambooBuildUrlBuilder(bambooPlanKey));
    }

    private class BambooBuildUrlBuilder extends UrlBuilder {
        public BambooBuildUrlBuilder(String bambooPlanKey) {
        }
    }
}
