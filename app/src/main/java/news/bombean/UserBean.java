package news.bombean;

import cn.bmob.v3.BmobObject;

/**
 * Created by baobiao on 2016/11/20.
 */

public class UserBean extends BmobObject {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
