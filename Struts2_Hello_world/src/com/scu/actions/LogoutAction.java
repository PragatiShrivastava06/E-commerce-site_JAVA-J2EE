package com.scu.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.remove("userId");
		session.remove("logined");
		session.remove("shippingid");
		session.remove("context");
		return SUCCESS;
	}

}