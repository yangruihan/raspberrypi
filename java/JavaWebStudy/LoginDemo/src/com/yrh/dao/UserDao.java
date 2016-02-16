package com.yrh.dao;

import com.yrh.model.User;

/**
 * Created by yrh on 16-2-16.
 */
public class UserDao {

    public boolean check(User user) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}
