package com.scu.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scu.bean.Product;
import com.scu.bean.ProductFeedback;
import com.scu.logic.BackendLogic;

public class ProductDetailAction extends ActionSupport {
	private static final long serialVersionUID = -1671484747917720668L;
	private Product product = new Product();
	BackendLogic logic = new BackendLogic();
	private int productID = 0;
	private String idToDelete;
	private boolean delRes;
	private String userId;
	private boolean admin;
	// New code for file upload may need to remove if does not work --Pragati
	private String destPath;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private int orderId;
	private ProductFeedback productFeedback = new ProductFeedback();
	private List<ProductFeedback> feedbackList = new ArrayList<ProductFeedback>();
	public String execute() {

		System.out.println(fileUpload);
		System.out.println(fileUploadContentType);
		System.out.println(fileUploadFileName);
		productFeedback.setProductId(getProductID());
		productFeedback.setUserId(userId);
		if (product.getProductName() != null
				&& !"".equals(product.getProductName())) {
			if (product.getProductID() != null
					&& !"".equals(product.getProductID())) {
				updateProduct();
			} else {
				saveProduct();
			}
		}
		if (productID > 0) {
			getProductByID();
		}
		return SUCCESS;
	}

	private void getProductByID() {
		product = logic.getProductByID(productID);
		if (product == null) {
			addActionError("Product Id does not exsist.");
		}
	}

	public String saveProduct() {
		if(validateProduct()){
		boolean isAdded = logic.addProduct(product);
		if (isAdded) {
			addActionError("New Product is added successfully.");
			product = new Product();
			return SUCCESS;
		} else {
			return ERROR;
		}
		}else {
			return ERROR;
		}
	}


	private boolean validateProduct() {
		boolean isvalid =true;
		if(product.getProductName() == null || "".equals(product.getProductName())){
			addActionError("Please provide Book's Name.");
			isvalid= false;
		}
		if(product.getAuthor() == null || "".equals(product.getAuthor())){
			addActionError("Please provide Author Name.");
			isvalid =false;
		}
		return isvalid;
	}

	public String addProduct() {
		// show add product page
		product = new Product();
		return SUCCESS;
	}

	public String editProduct() {
		// show add product page
		isAdmin();
		getProductByID();
		fetchFeedback();
		if (!admin) {
			insertViewedIteam();
		}
		return SUCCESS;
	}

	private void insertViewedIteam() {
		logic.insertViewdIteam(userId, product.getProductID());
	}

	public String updateProduct() {
		boolean isUpdated = logic.updateProductDetail(product);
		if (isUpdated) {
			addActionError("Product is updated successfully.");
			return SUCCESS;
		} else {
			return ERROR;
		}
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

	public String giveFeedback() {
		System.out.println(productID);
		System.out.println(getProductID());
		System.out.println(userId);
		productFeedback.setProductId(getProductID());
		productFeedback.setUserId(userId);
		boolean isAdded = logic.giveFeedback(productFeedback);
		if (isAdded) {
			addActionError("New Product Feedback is added successfully.");
		} else {
			addActionError("User is not allowed to give feedback again.");
		}
		fetchFeedback();
		getProductByID();
		return SUCCESS;
	}

	public String fetchFeedback() {

		feedbackList = logic.fetchFeedbackList(productID);
		return SUCCESS;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isAdmin() {
		if (admin) {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			admin = (Boolean) session.get("admin");
		} else {
			admin = logic.getUserType(userId);
		}
		return admin;
	}

	public String getUserId() {
		if (userId == null || "null".equals(userId) || "".equals(userId)) {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			userId = (String) session.get("userId");
		}
		return userId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductID() {
		if(productID == 0){
			try{
			productID = new Integer(product.getProductID());
			}catch(Exception ex){
				//Need not to do anything as its for feedback logic
			}
		}
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public List<ProductFeedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<ProductFeedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public ProductFeedback getProductFeedback() {
		return productFeedback;
	}

	public void setProductFeedback(ProductFeedback productFeedback) {
		this.productFeedback = productFeedback;
	}

	public List<Integer> getRatingList() {
	 List<Integer> ratingList = new ArrayList<Integer>();
		ratingList.add(1);
		ratingList.add(2);
		ratingList.add(3);
		ratingList.add(4);
		ratingList.add(5);
		return ratingList;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


}
