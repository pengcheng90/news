package news.bombean;

import cn.bmob.v3.BmobObject;

/**
 * Created by baobiao on 2016/11/20.
 */

public class FeedbackBean extends BmobObject {
    private String username;
    private String feed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }
}
