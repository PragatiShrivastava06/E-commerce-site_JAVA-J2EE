package com.scu.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.OrderDetail;
import com.scu.bean.OrderProductMapping;
import com.scu.bean.Shipping;
import com.scu.logic.BackendLogic;

public class OrderDetailAction extends ActionSupport {

	private static final long serialVersionUID = -7944662099081152386L;

	private List<OrderDetail> orderList = new ArrayList<OrderDetail>();
	private String userId;
	private BackendLogic logic = new BackendLogic();
	private OrderDetail orderdetail;
	private List<OrderProductMapping> orderproductmapping = new ArrayList<OrderProductMapping>();
	private String orderId;
	private String shippingId;
	private Shipping shippingbean;
	
	public String showOrder() {
		orderList = logic.getOrderListByUserId(userId);
		return SUCCESS;
	}
	
	public String showOrderDetails(){
		orderproductmapping = logic.getorderproductmappingByOrderId(orderId);
		shippingbean = logic.getShippingDetailsById(shippingId);
		return SUCCESS;
	}

	public List<OrderDetail> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderDetail> orderList) {
		this.orderList = orderList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public OrderDetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	public List<OrderProductMapping> getOrderproductmapping() {
		return orderproductmapping;
	}

	public void setOrderproductmapping(List<OrderProductMapping> orderproductmapping) {
		this.orderproductmapping = orderproductmapping;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public Shipping getShippingbean() {
		return shippingbean;
	}

	public void setShippingbean(Shipping shippingbean) {
		this.shippingbean = shippingbean;
	}


}
