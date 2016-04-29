package com.scu.actions;

import java.io.File;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.Product;
import com.scu.logic.BackendLogic;
//Not in use need to check
public class ProductAction extends ActionSupport {
	private static final long serialVersionUID = -3095827356839798593L;
	private ArrayList<Product> resultList = new ArrayList<Product>();
	private BackendLogic logic = new BackendLogic();
	private String idToDelete;
	private boolean delRes;
	

	public String execute() {
		// resultList = logic.addProduct(addProductTransport);
		return SUCCESS;
	}

	public String deleteProduct() {
		try {
			delRes = logic.deleteProductById(idToDelete);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (delRes) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public ArrayList<Product> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<Product> resultList) {
		this.resultList = resultList;
	}

	public String getIdToDelete() {
		return idToDelete;
	}

	public void setIdToDelete(String idToDelete) {
		this.idToDelete = idToDelete;
	}

	public boolean isDelRes() {
		return delRes;
	}

	public void setDelRes(boolean delRes) {
		this.delRes = delRes;
	}
}
