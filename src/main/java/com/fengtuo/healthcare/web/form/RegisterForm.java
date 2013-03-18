package com.fengtuo.healthcare.web.form;

import com.fengtuo.healthcare.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/18/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterForm {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser(){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    }
}
