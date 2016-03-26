package com.yrh.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if (ActionContext.getContext().getSession().get("LOGIN_INFO") != null
				&& ((String) ActionContext.getContext().getSession()
						.get("LOGIN_INFO")).equals("admin")) {
			String result = invocation.invoke();
			return result;
		}
		return "error";
	}
}
