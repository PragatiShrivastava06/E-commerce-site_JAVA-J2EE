package com.scu.actions;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scu.logic.BackendLogic;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -9034139350116248417L;
	private String username;
	private String userId;
	private String password;
	private BackendLogic logic = new BackendLogic();

	public String execute() {
		if (!"".equals(userId) && userId != null && !"".equals(password)
				&& password != null) {
			boolean isValidUser = logic.validateUser(userId, password);
			if (isValidUser) {
				boolean isAdmin = logic.getUserType(userId);

				Map<String, Object> session = ActionContext.getContext()
						.getSession();
				session.put("logined", "true");
				session.put("userId", userId);
				session.put("admin", isAdmin);
				session.put("context", new Date());

				return SUCCESS;
			} else {
				addActionError("Please Insert valid Userid and/or Password.");
				return ERROR;
			}
		} else {
			addActionError("Please Insert required fields.");
			return ERROR;
		}
	}

	public String guestlogin() {
		userId = "Guest";
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("logined", "true");
		session.put("userId", userId);
		session.put("admin", false);
		session.put("context", new Date());
		return SUCCESS;
	}
	
	public String logout() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("userId");
		session.remove("logined");
		session.remove("context");
		return SUCCESS;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
