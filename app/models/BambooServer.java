package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/8/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */

public class BambooServer extends RestServer {

    private BambooBuildAPI bambooBuildAPI;
    private BambooServerConfiguration configuration;

    public BambooServer(BambooServerConfiguration serverConfiguration) {
        super(new UsernamePasswordAuthentication(serverConfiguration.getBambooUserName(), serverConfiguration.getBambooPassword()));
        bambooBuildAPI = new BambooBuildAPI(this);
        this.configuration = serverConfiguration;
    }

    public BambooBuildAPI bambooBuildAPI() {
        return this.bambooBuildAPI;
    }

    public String getBambooServerUrl() {
        return this.configuration.getBambooUrl();
    }
}
