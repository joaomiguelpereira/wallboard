package models;

import play.libs.WS;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 09-04-2013
 * Time: 0:59
 * To change this template use File | Settings | File Templates.
 */
public class UrlBuilder {
    protected String url;
    protected Map<String, String> parameters;

    public UrlBuilder(String baseUrl) {
        this.url = baseUrl;
        this.parameters = new HashMap<String, String>();
    }

    public String getUrl() {
        return this.url;
    }

    public void buildRequestQueryString(WS.WSRequestHolder wsreqHolder) {
        for (String key : this.parameters.keySet()) {
            wsreqHolder.setQueryParameter(key, this.parameters.get(key));

        }

    }

    public void addParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}

