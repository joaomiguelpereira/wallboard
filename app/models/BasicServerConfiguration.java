package models;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/9/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicServerConfiguration {

    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return this.url;

    }

    public String getUserName() {
        return this.userName;

    }

    public String getPassword() {
        return password;
    }

    public abstract static class Builder<T extends BasicServerConfiguration> {

        public Builder withUrl(String jiraUrl) {
            getConfigObject().url = jiraUrl;
            return this;

        }

        public Builder withUserName(String userName) {
            getConfigObject().userName = userName;
            return this;
        }

        public Builder withPassword(String password) {
            getConfigObject().password = password;
            return this;
        }

        protected abstract BasicServerConfiguration getConfigObject();

        public abstract T build();


    }
}
