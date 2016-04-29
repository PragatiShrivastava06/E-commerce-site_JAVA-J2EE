package com.scu.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.InventoryProductManagement;
import com.scu.logic.BackendLogic;

public class InventoryProductManagementAction extends ActionSupport {

	private static final long serialVersionUID = -8193428404716082844L;
	private String userId;
	private String inventoryId;
	private String selectedIDs;
	private String productId;
	private List<InventoryProductManagement> invProList = new ArrayList<InventoryProductManagement>();
	private BackendLogic logic = new BackendLogic();
	private InventoryProductManagement selectedMap = new InventoryProductManagement();
	
	public String editInventory() {
		System.out.println("inside editInventory");
		invProList = logic.getinvProList(inventoryId);
		return SUCCESS;
	}

	public String editQuantity() {
		selectedMap = logic.getInventoryProductManagement(inventoryId,
				productId);
		return SUCCESS;
	}
	
	public String addNewProductQuant() {
		System.out.println(inventoryId);
		selectedMap = new InventoryProductManagement();
		selectedMap.setInventoryId(new Long(inventoryId));
		return SUCCESS;
	}
	

	public String deleteProductFromInv() {
		boolean isDeleted = logic
				.deleteProductFromInv(inventoryId, selectedIDs);
		if (isDeleted) {
			editInventory();
		}
		return SUCCESS;
	}

	public String insertInvPro() {
		logic.insertInvPro(selectedMap);
		selectedMap = new InventoryProductManagement();
		addActionError("Details has been added Successfully. Add new details below");

		return SUCCESS;
	}

	public String updateInvPro() {
		System.out.println("inside update");
		logic.updateInvPro(selectedMap);

//		if (inventoryId == null || "".equals(inventoryId)) {
//		inventoryId = selectedMap.getInventoryId()+"";
//	}
//	if (productId == null || "".equals(productId)) {
//		productId = selectedMap.getProductId() +"";
//	}
//	editQuantity();
		addActionError("Details has been updated Successfully.");

		return SUCCESS;
	}

	public String updateInventory() {
		addActionError("Updated successfully.");

		System.out.println(invProList);
		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<InventoryProductManagement> getInvProList() {
		return invProList;
	}

	public void setInvProList(List<InventoryProductManagement> invProList) {
		this.invProList = invProList;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getSelectedIDs() {
		return selectedIDs;
	}

	public void setSelectedIDs(String selectedIDs) {
		this.selectedIDs = selectedIDs;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public InventoryProductManagement getSelectedMap() {
		return selectedMap;
	}

	public void setSelectedMap(InventoryProductManagement selectedMap) {
		this.selectedMap = selectedMap;
	}

}
