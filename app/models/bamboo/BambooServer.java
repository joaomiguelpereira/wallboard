package models.bamboo;

import models.RestServer;
import models.UsernamePasswordAuthentication;

/**
 * A simple Bamboo REST Server.
 */

public class BambooServer extends RestServer {

    private BambooBuildAPI bambooBuildAPI;
    private BambooServerConfiguration configuration;

    public BambooServer(BambooServerConfiguration serverConfiguration) {
        super(new UsernamePasswordAuthentication(serverConfiguration.getUserName(), serverConfiguration.getPassword()));
        bambooBuildAPI = new BambooBuildAPI(this);
        this.configuration = serverConfiguration;
    }

    public BambooBuildAPI bambooBuildAPI() {
        return this.bambooBuildAPI;
    }

    public String getBambooServerUrl() {
        return this.configuration.getUrl();
    }
}
