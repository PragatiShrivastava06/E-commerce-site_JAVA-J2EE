package com.scu.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.OrderDetail;
import com.scu.logic.BackendLogic;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 6948270495650180321L;
	BackendLogic logic = new BackendLogic();
	private List<OrderDetail> orderList = new ArrayList<OrderDetail>();
	
	
	public String showReport() {
		orderList = logic.getOrderList();
		return SUCCESS;
	}

	public List<OrderDetail> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderDetail> orderList) {
		this.orderList = orderList;
	}
}
