package com.xy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.xy.model.User;
import com.xy.service.UserServiceInter;

//@ParentPackage("basePackage")
//@Action(value="test")//使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action
//@Namespace("/")//使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间

@ParentPackage("struts-default")//父包
@Namespace("")
@Results({ @Result(name = "success", location = "/msg.jsp"),
		@Result(name = "error", location = "/error.jsp") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })

public class TestAction extends ActionSupport{
	private static final long serialVersionUID = 3265453666704958799L;
	/**
     * 注入userService
     */
    @Autowired
    private UserServiceInter userService;

    /**
     * http://localhost:8080/SSH/strust2Test!test.action
     * MethodName: test
     * Description: 
     * @author xudp
     */
    @Action("test")
    public String test(){
        System.out.println("进入TestAction");
        return SUCCESS;
    }
    
    /**
     * http://localhost:8080/SSH/strust2Test!saveUser.action
     */
    @Action(value = "saveUser", results = { @Result(name = "success", location = "/index.jsp") })
    public String saveUser(){
        User user = new User();
        user.setName("asdfas");
        user.setPassword("sadfadfs");
        userService.save(user);
        return SUCCESS;
    }
}