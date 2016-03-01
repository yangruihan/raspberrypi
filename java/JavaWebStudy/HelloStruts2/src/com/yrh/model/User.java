package com.yrh.model;

import java.util.List;

/**
 * Created by Yrh on 2016/2/24.
 */
public class User {
    private String username;
    private String password;
    private List<String> favorites;

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

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }
}
