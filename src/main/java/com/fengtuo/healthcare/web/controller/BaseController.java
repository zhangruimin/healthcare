package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.User;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/17/13
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseController {
    public User getCurrentUser(HttpSession session){
        return (User)session.getAttribute("currentUser");
    }
}
