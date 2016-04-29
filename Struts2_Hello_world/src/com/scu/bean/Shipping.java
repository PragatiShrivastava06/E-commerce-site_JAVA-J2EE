package com.scu.bean;

public class Shipping {

	private String userId;
	private String shippingId;
	private String deliverCity;
	private String deliverStreet;
	private String deliverState;

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getDeliverCity() {
		return deliverCity;
	}

	public void setDeliverCity(String deliverCity) {
		this.deliverCity = deliverCity;
	}

	public String getDeliverStreet() {
		return deliverStreet;
	}

	public void setDeliverStreet(String deliverStreet) {
		this.deliverStreet = deliverStreet;
	}

	public String getDeliverState() {
		return deliverState;
	}

	public void setDeliverState(String deliverState) {
		this.deliverState = deliverState;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
