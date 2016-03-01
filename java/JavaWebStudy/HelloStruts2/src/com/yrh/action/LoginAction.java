package com.yrh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yrh.model.User;

/**
 * Created by Yrh on 2016/2/24.
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    public String login() {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getFavorites().get(0));
        System.out.println(user.getFavorites().get(1));
        return SUCCESS;
    }

    @Override
    public User getModel() {
        return user;
    }
}
