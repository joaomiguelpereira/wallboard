package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class JiraServerFactory {

    public JiraServer create(JiraServerConfiguration serverConfiguration) {

        JiraServer server = new JiraServer(serverConfiguration);

        return server;
    }
}
