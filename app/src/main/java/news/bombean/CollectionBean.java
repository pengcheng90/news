package news.bombean;

import cn.bmob.v3.BmobObject;

/**
 * Created by baobiao on 2016/11/20.
 */

public class CollectionBean extends BmobObject{
    private String url;

    private String title;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
