package models.jira;

import models.RestServer;
import models.UsernamePasswordAuthentication;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/7/13
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class JiraServer extends RestServer {

    private final String serverURL;
    private final GreenhopperAPI greenhopperAPI;

    public JiraServer(JiraServerConfiguration serverConfiguration) {
        super(new UsernamePasswordAuthentication(serverConfiguration.getUserName(), serverConfiguration.getPassword()));

        this.serverURL = serverConfiguration.getUrl();
        this.greenhopperAPI = new GreenhopperAPI(this);
    }

    public GreenhopperAPI greenhopperApi() {
        return greenhopperAPI;
    }

    public String getServerURL() {
        return serverURL;
    }

}
