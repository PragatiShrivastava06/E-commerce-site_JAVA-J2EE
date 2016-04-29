package com.scu.actions;

import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scu.logic.BackendLogic;
import com.scu.transport.ResultTransport;
import com.scu.transport.SearchTransport;

public class SearchAction extends ActionSupport {
	private static final long serialVersionUID = -2767241191084658656L;
	private SearchTransport searchTransport = new SearchTransport();
	private ArrayList<ResultTransport> resultList = new ArrayList<ResultTransport>();
	private ArrayList<ResultTransport> viewedList = new ArrayList<ResultTransport>();
	
	private BackendLogic logic = new BackendLogic();
	private String actionType;
	private String productID;
	private String productIds;
	private String userId;
	private boolean admin;


	// private boolean isTest = false;

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isAdmin() {
		if (admin) {
			Map session = ActionContext.getContext().getSession();
			admin = (Boolean) session.get("admin");
		} else {
			admin = logic.getUserType(userId);
		}
		return admin;
	}

	public String execute() {
		if(userId == null){
			getUserId();
		}
		System.out.println("inside exe searchaction");
		loadViewedIteam();
		return SUCCESS;
	}

	private void loadViewedIteam() {
		if(userId == null){
			getUserId();
		}
		if(viewedList == null || viewedList.size() ==0){
			viewedList = logic.loadViewedIteam(userId);
		}
		System.out.println(viewedList.size());
	}

	public String searchProduct() {
		System.out.println(isAdmin());
		resultList = logic.getProductList(searchTransport);
		if (resultList == null || resultList.size() <= 0) {
			addActionError("No Record Found for given input");
		}
		loadViewedIteam();
		return SUCCESS;

	}

	/*
	 * This is just a test method for testing -- Pragati private
	 * ArrayList<ResultTransport> getDummyList() { ArrayList<ResultTransport>
	 * temp = new ArrayList<ResultTransport>(); for (int i = 0; i < 10; i++) {
	 * ResultTransport p = new ResultTransport(); p.setProductID("" + i);
	 * p.setProductName("MyBookNo" + i); p.setAuthor("Author"+i);
	 * p.setPrice(100*i+5); temp.add(p); } return temp; }
	 */

	public String deleteProduct() {
		System.out.println(productIds);
		boolean delRes = false;
		try {
			if(productIds != null || !"".equals(productIds) || !"null".equals(productIds)){
			delRes = logic.deleteProductById(productIds);
			addActionError("Product has been Deleted Successfully");
			resultList = logic.getProductList(searchTransport);
			}else{
				addActionError("Please select products to delete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (delRes) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String addProductToCart() {
		System.out.println(productIds);
		System.out.println(getUserId());

		boolean showCart = false;
		try {
			showCart = logic.addProductToCart(productIds, getUserId());
			addActionError("Product has been added to Cart Successfully");
			resultList = logic.getProductList(searchTransport);
			getUserId();
			loadViewedIteam();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (showCart) {
			return SUCCESS;
		} else {
			addActionError("Please select a product");
			return ERROR;
		}

	}

	public String getUserId() {
		if (userId == null || "null".equals(userId) || "".equals(userId)) {
			Map session = ActionContext.getContext().getSession();
			userId = (String) session.get("userId");
		}
		return userId;
	}

	public SearchTransport getSearchTransport() {
		return searchTransport;
	}

	public void setSearchTransport(SearchTransport searchTransport) {
		this.searchTransport = searchTransport;
	}

	public ArrayList<ResultTransport> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<ResultTransport> resultList) {
		this.resultList = resultList;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public ArrayList<ResultTransport> getViewedList() {
		return viewedList;
	}

	public void setViewedList(ArrayList<ResultTransport> viewedList) {
		this.viewedList = viewedList;
	}


}
