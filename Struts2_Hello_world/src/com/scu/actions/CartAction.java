package com.scu.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.Cart;
import com.scu.bean.Shipping;
import com.scu.logic.BackendLogic;

public class CartAction extends ActionSupport {

	private static final long serialVersionUID = -7331152385862096570L;
	private String userId;
	private BackendLogic logic = new BackendLogic();
	private List<Cart> cartList = new ArrayList<Cart>();
	private String selectedIDs;
	private Shipping shippingbean = new Shipping();
	private String shippingId;
	private long total;

	public String getSelectedIDs() {
		return selectedIDs;
	}

	public void setSelectedIDs(String selectedIDs) {
		this.selectedIDs = selectedIDs;
	}

	public String showCart() {
		cartList = logic.getCartListByUser(userId);
		return SUCCESS;

	}

	public String removeFromCart() {
		boolean isRemoved = false;
		try {
			isRemoved = logic.removeFromCart(selectedIDs, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isRemoved) {
			showCart();
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String checkout() {
		System.out.println(shippingbean.getDeliverCity());
		shippingId = logic.addShippingAddress(shippingbean,userId);
		shippingbean.setShippingId( shippingId );
		Map<String, Object> session = ActionContext.getContext()
				.getSession();
		session.put("shippingid", shippingId);
		String message = logic.checkout(userId);
		if ("".equals(message)) {
			addActionError("Please make required payment");
			return SUCCESS;
		} else {
			addActionError(message);
			if (cartList.size() <= 0) {
				cartList = logic.getCartListByUser(userId);
			}
			return ERROR;
		}

	}

	public String getUserId() {
		if (userId == null || "".equals(userId)) {
			Map session = ActionContext.getContext().getSession();
			userId = (String) session.get("userId");
		}
		System.out.println(userId);
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public Shipping getShippingbean() {
		return shippingbean;
	}

	public void setShippingbean(Shipping shippingbean) {
		this.shippingbean = shippingbean;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
