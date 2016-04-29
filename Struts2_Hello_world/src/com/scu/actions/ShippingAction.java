package com.scu.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.Shipping;

public class ShippingAction extends ActionSupport {
	private static final long serialVersionUID = 6049317929746551330L;
	private Shipping shippingbean = new Shipping();

	public Shipping getShippingbean() {
		return shippingbean;
	}

	public void setShippingbean(Shipping shippingbean) {
		this.shippingbean = shippingbean;
	}

}
