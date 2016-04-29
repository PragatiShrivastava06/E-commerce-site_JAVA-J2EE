package com.scu.bean;

public class Inventory {

	private long inventoryId;
	private long quantity;
	private String inventoryLocation;

	public long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getInventoryLocation() {
		return inventoryLocation;
	}
	
	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}

}
