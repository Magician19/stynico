package nico.styTool;

import cn.bmob.v3.BmobObject;

/**
 * Created by luxin on 15-12-17.
 *  http://luxin.gitcafe.io
 */
public class Comment extends BmobObject {
    private MyUser user;
    private String comment;
    private Helps_a helps;

    public Helps_a getHelps() {
        return helps;
    }

    public void setHelps(Helps_a helps) {
        this.helps = helps;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
