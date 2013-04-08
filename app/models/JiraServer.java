package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/7/13
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class JiraServer {

    private final UsernamePasswordAuthentication authentication;
    private final String serverURL;
    private final GreenhopperAPI greenhopperAPI;

    public JiraServer(JiraServerConfiguration serverConfiguration) {

        this.serverURL = serverConfiguration.getJiraUrl();
        this.authentication = new UsernamePasswordAuthentication(serverConfiguration.getJiraUserName(),serverConfiguration.getJiraPassword());
        this.greenhopperAPI = new GreenhopperAPI(this);
    }



    public String getUserName() {
        return authentication.getUserName();
    }

    public String getPassword() {
        return authentication.getPassword();
    }

    public GreenhopperAPI greenhopperApi() {
        return greenhopperAPI;
    }

    public String getServerURL() {
        return serverURL;
    }
}
