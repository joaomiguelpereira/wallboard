package models;

import play.libs.WS;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 09-04-2013
 * Time: 0:59
 * To change this template use File | Settings | File Templates.
 */
public class UrlBuilder {
    protected String boardId;
    protected String url;

    public UrlBuilder(String url, String id) {
        this.url = url;
        this.boardId = id;
    }


    public UrlBuilder() {
    }

    public String getUrl() {
        return this.url + this.boardId;
    }


    public void setParameters(WS.WSRequestHolder wsreqHolder) {

    }
}

