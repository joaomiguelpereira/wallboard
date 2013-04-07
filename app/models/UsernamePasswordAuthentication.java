package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 07-04-2013
 * Time: 4:30
 * To change this template use File | Settings | File Templates.
 */
public class UsernamePasswordAuthentication {

    private String userName;
    private String passwordd;

    public UsernamePasswordAuthentication(String userName, String passwordd) {
        this.userName = userName;
        this.passwordd = passwordd;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return passwordd;
    }
}
