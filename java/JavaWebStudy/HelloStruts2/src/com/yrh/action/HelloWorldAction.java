package com.yrh.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Yrh on 2016/2/24.
 */
public class HelloWorldAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("执行Action");
        return SUCCESS;
    }
}
