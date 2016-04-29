package com.scu.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.User;
import com.scu.logic.BackendLogic;

public class UserDetailAction extends ActionSupport {
	private static final long serialVersionUID = 7214226919694419011L;
	private User user = new User();
	BackendLogic logic = new BackendLogic();
	private String userID;
	private boolean isAdmin = false;
	private boolean adminAdding = false;
	private String userId;
	private boolean admin;	

	public String execute() {
		if (user.getUserID() != null && !"".equals(user.getUserID())) {
			if (user.getUserName() != null && !"".equals(user.getUserName())) {
				updateUser();
			} else {
				saveUser();
			}
		}
		if (userID != null) {
			getUserByID();
		}
		return SUCCESS;
	}

	public String registration() {
		return SUCCESS;
	}
	
	public String addUserByAdmin(){
		adminAdding = true;
		return SUCCESS;
	}

	public String saveUser() {
		boolean isAdded = logic.addUser(user);
		if (isAdded) {
			addActionError("New User is added scussfully. Please Login with new User");
			return SUCCESS;
		} else {
			addActionError("Please select another User Id");
			return ERROR;
		}
	}

	private String updateUser() {
		boolean isUpdated = logic.updateUserDetail(user);
		if (isUpdated) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	private void getUserByID() {
		user = logic.getUserByID(userID);

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public boolean isAdmin() {
		if (admin) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			admin = (Boolean) session.get("admin");
		} else {
			admin = logic.getUserType(userId);
		}
		return admin;
	}

	public boolean isAdminAdding() {
		return adminAdding;
	}

	public void setAdminAdding(boolean adminAdding) {
		this.adminAdding = adminAdding;
	}

}