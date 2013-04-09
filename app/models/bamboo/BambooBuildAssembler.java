package models.bamboo;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 09-04-2013
 * Time: 0:51
 * To change this template use File | Settings | File Templates.
 */
public class BambooBuildAssembler {

    private BambooServer bambooServer;

    public BambooBuildAssembler(BambooServer bambooServer) {
        this.bambooServer = bambooServer;
    }

    public BambooBuild assemble(String bambooPlanKey) {
        String json = bambooServer.bambooBuildAPI().getBuild(bambooPlanKey);

        return null;
    }

}
