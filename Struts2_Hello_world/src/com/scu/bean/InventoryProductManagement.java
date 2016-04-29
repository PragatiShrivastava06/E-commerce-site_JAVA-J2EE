package com.scu.bean;

public class InventoryProductManagement {

	private long productId;
	private long inventoryId;
	private long productQuantity;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	@Override
	public String toString(){
		
		return productId+"~"+inventoryId+"~"+"productQuantity";
		
	}
}
