package com.scu.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.CreditCardDetail;
import com.scu.logic.BackendLogic;

public class PaymentAction extends ActionSupport{	
	private static final long serialVersionUID = -6062028676258858668L;
	private CreditCardDetail creditDetail = new CreditCardDetail();
	private BackendLogic logic = new BackendLogic();
	private String userId;	
	private String shippingId;

	public String payAmount() {
		if(creditDetail.getShippingId() == null || "".equals(creditDetail.getShippingId())){
			creditDetail.setShippingId(shippingId);
		}
		logic.insertCCdetails(creditDetail, userId);//this need to update with payment gateway
		logic.orderNow(creditDetail.getCreditCardNumber(), userId, creditDetail.getShippingId());
		logic.clearCart(userId);
		addActionError("Payment is Done Successfully.");

		return SUCCESS;
	}
	
	public String cancelTransection() {
		logic.clearCart(userId);
		addActionError("Transection Has been canceled and cart is now empty for you.");

		return SUCCESS;
	}
	
	public CreditCardDetail getCreditDetail() {
		return creditDetail;
	}

	public void setCreditDetail(CreditCardDetail creditDetail) {
		this.creditDetail = creditDetail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}
}
