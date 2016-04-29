package com.scu.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.Inventory;
import com.scu.logic.BackendLogic;

public class InventoryAction extends ActionSupport {

	private static final long serialVersionUID = 8558600462696003011L;
	private String userId;
	private List<Inventory> inventoryList  = new ArrayList<Inventory>();
	private BackendLogic logic = new BackendLogic();

	public String showInventory() {
		inventoryList = logic.getinventories();
		System.out.println(inventoryList);
		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

}
