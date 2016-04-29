package com.scu.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.scu.bean.Cart;
import com.scu.bean.CreditCardDetail;
import com.scu.bean.Inventory;
import com.scu.bean.InventoryProductManagement;
import com.scu.bean.OrderDetail;
import com.scu.bean.OrderProductMapping;
import com.scu.bean.Product;
import com.scu.bean.ProductFeedback;
import com.scu.bean.Shipping;
import com.scu.bean.User;
import com.scu.connecctions.ScuDbConn;
import com.scu.dbsql.SelectQueries;
import com.scu.transport.ResultTransport;
import com.scu.transport.SearchTransport;

public class BackendLogic {

	ScuDbConn dbConnection = new ScuDbConn();
	SelectQueries query = new SelectQueries();

	public ArrayList<ResultTransport> getProductList(
			SearchTransport searchTransport) {
		String sql = query.createSqlForSearch(searchTransport);
		ArrayList<ResultTransport> outList = dbConnection
				.getProductForSearch(sql);
		return outList;
	}

	public boolean addProduct(Product product) {

		String sql = query.createSqlForAddProduct(product);
		boolean isAdded = dbConnection.insertIntoDB(sql);
		return isAdded;
	}

	public boolean deleteProductById(String idToDelete) {
		String sql = query.createSqlForDeleteProductById(idToDelete);
		boolean isDeleted = dbConnection.deleteFromDB(sql);
		return isDeleted;

	}

	public boolean updateProductDetail(Product product) {
		String sql = query.createSqlUpdateProduct(product);
		boolean isUpdate = dbConnection.updateToDB(sql);
		return isUpdate;
	}

	public Product getProductByID(int productID) {
		String sql = query.getProductByID(productID);
		Product output = dbConnection.getProductFromSql(sql);
		return output;
	}

	public boolean addUser(User user) {
		String sql = query.createSqlForAddUser(user);
		boolean isAdded = dbConnection.insertIntoDB(sql);
		return isAdded;
	}

	public boolean deleteUserById(String idToDelete) {
		String sql = query.createSqlForDeleteProductById(idToDelete);
		boolean isDeleted = dbConnection.deleteFromDB(sql);
		return isDeleted;

	}

	public boolean updateUserDetail(User user) {
		String sql = query.createSqlUpdateUser(user);
		boolean isUpdate = dbConnection.updateToDB(sql);
		return isUpdate;
	}

	public User getUserByID(String userID) {
		String sql = query.getUserByID(userID);
		User output = dbConnection.getUserFromSql(sql);
		return output;
	}

	public boolean validateUser(String userID, String password) {
		String sql = query.getPasswordByUserId(userID);
		String passwordFromDB = dbConnection.getValueFromSql(sql);
		if (password != null && password.equals(passwordFromDB)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean addProductToCart(String productIds, String userId) {
		String sql = query.insertIntoCart(productIds, userId);
		boolean isAdded = dbConnection.insertIntoDB(sql);
		return isAdded;
	}

	public List<Cart> getCartListByUser(String userId) {
		String sql = query.getCartListByUser(userId);
		ArrayList<Cart> outList = dbConnection.getCartListByUser(sql);
		System.out.println(outList.size());
		return outList;
	}

	public boolean getUserType(String userId) {
		String sql = query.getIsUserAnAdmin(userId);
		String isAdminInt = dbConnection.getValueFromSql(sql);
		if ("1".equals(isAdminInt)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean removeFromCart(String selectedIDs, String userId) {
		String sql = query.createSqlForRemoveFromCart(selectedIDs, userId);
		boolean isDeleted = dbConnection.deleteFromDB(sql);
		return isDeleted;
	}

	public String checkout(String userId) {
		List<Cart> tempList = getCartListByUser(userId);
		String message = checkAvailability(tempList);
		return message;
	}

	public String makePayment(String userId){
		List<Cart> tempList = getCartListByUser(userId);
		String message = checkAvailability(tempList);
		if (!"".equals(message)) {
			for (Cart c : tempList) {
				reduceProductFromInventory(c.getProductId(), c.getQuantity());
			}
		}
		return message;
	}
	private String checkAvailability(List<Cart> tempList) {
		String message = "";
		String productIds = "";
		for (Cart c : tempList) {
			if (!"".equals(productIds)) {
				productIds = productIds + ",";
			}
			productIds = productIds + c.getProductId();
		}

		String sqlavailability = query.getPrdocutCountSql(productIds);
		Map<String, String> productQuantityMap = dbConnection
				.getKeyValueFromSql(sqlavailability);

		for (Cart c : tempList) {
			String quantityAvailable = productQuantityMap.get(c.getProductId());
			if(quantityAvailable == null || "".equals(quantityAvailable)){
				quantityAvailable = "0";
			}
			if ((new Integer(quantityAvailable).intValue()) < c.getQuantity()) {
				message = "Product '" + c.getProductName()
						+ "' is not available in desire quantity in Stock. Please order after some time \n";
			}
		}

		return message;

	}

	public boolean reduceProductFromInventory(String productid, long quantity) {

		String sql = query.createSqlToUpdateInventory(productid, quantity);
		boolean isUpdate = dbConnection.updateToDB(sql);
		return isUpdate;
	}

	public void clearCart(String userId) {
		String sql = query.getClearCartSql(userId);
		dbConnection.deleteFromDB(sql);
	}

	//Need to remove
	public void payAmout(String userId) {
		List<Cart> orderList = getCartListByUser(userId);
		query.insertintoOrderDetail(orderList, userId);
	}

	public void insertViewdIteam(String userId, String productID) {
		String sql = query.sqlForInsertViewdIteam(userId, productID );
		boolean isInsert = dbConnection.insertIntoDB(sql);
		if(!isInsert){
			System.out.println("Recored already there");
		}
	}

	public ArrayList<ResultTransport> loadViewedIteam(String userId) {
		String sql = query.loadViewedIteam(userId);
		ArrayList<ResultTransport> outList = dbConnection
				.getProductForSearch(sql);
		return outList;
		}

	public String addShippingAddress(Shipping shippingbean, String userId) {
		String sql = query.addShippingAdress(shippingbean, userId); 	
		dbConnection.insertIntoDB(sql);
		sql = null;
		sql= query.getShippingId();
		return dbConnection.getValueFromSql(sql);
	}

	public void insertCCdetails(CreditCardDetail creditDetail, String userId) {
		String sql = query.addCCdetail(creditDetail, userId); 	
		dbConnection.insertIntoDB(sql);
	}

	public void orderNow(String creditCardNumber, String userId, String shippingId) {
		createOrder( creditCardNumber,  userId, shippingId);
		processOrder(userId);
	}

	private void createOrder(String creditCardNumber, String userId, String shippingId) {
		String sql = query.createOrder(creditCardNumber, userId, shippingId); 	
		dbConnection.insertIntoDB(sql);		
	}
		
	private void processOrder(String userId) {
		String sql= query.getOrderDetailId();
		String orderId = dbConnection.getValueFromSql(sql);	
		List<Cart> tempList = getCartListByUser(userId);
		//String message = checkAvailability(tempList);
			for (Cart c : tempList) {
				reduceProductFromInventory(c.getProductId(), c.getQuantity());
				addOrderProductMapping(c.getProductId(), orderId, c.getQuantity(), 0 );
			}
		
	}

	private void addOrderProductMapping(String productId, String orderId,
			long quantity, int price) {
		String sql = query.addOrderProductMapping( productId,  orderId,
				 quantity,  price); 	
		dbConnection.insertIntoDB(sql);	
		
	}

	public List<Inventory> getinventories() {
		String sql = query.getinventories();
		ArrayList<Inventory> outList = dbConnection.getinventories(sql);
		System.out.println(outList.size());
		return outList;
	}

	public List<InventoryProductManagement> getinvProList( String inventoryId) {
		String sql = query.getinvProList(inventoryId);
		ArrayList<InventoryProductManagement> outList = dbConnection.getinvProList(sql);
		System.out.println(outList.size());
		return outList;	}

	public boolean deleteProductFromInv(String inventoryId, String selectedIDs) {
		String sql = query.createSqlForRemoveFromInv(selectedIDs, inventoryId);
		boolean isDeleted = dbConnection.deleteFromDB(sql);
		return isDeleted;
	}

	public InventoryProductManagement getInventoryProductManagement(
			String inventoryId, String productId) {
		String sql = query.getInventoryProductManagement(inventoryId, productId);
		InventoryProductManagement output = dbConnection.getInventoryProductManagementFromSql(sql);
		return output;
	}

	//Not in use need to remove
	public void insertInvPro(InventoryProductManagement selectedMap) {
		String sql = query.sqlForInsertInvPro(selectedMap);
		dbConnection.insertIntoDB(sql);
		
	}

	public boolean updateInvPro(InventoryProductManagement selectedMap) {
		String sql = query.sqlForUpdateInvPro(selectedMap);
		boolean isUpdate = dbConnection.updateToDB(sql);
		return isUpdate;		
	}

	public List<OrderDetail> getOrderListByUserId(String userId) {
		String sql = query.getOrderListByUserId(userId);
		ArrayList<OrderDetail> outList = dbConnection
				.getOrderList(sql);
		System.out.println(outList.size());
		return outList;	
	}

	public List<OrderProductMapping> getorderproductmappingByOrderId(
			String orderId) {
		String sql = query.getorderproductmappingByOrderId(orderId);
		ArrayList<OrderProductMapping> outList = dbConnection
				.getOrderProductMappingList(sql);
		return outList;
	}

	public boolean giveFeedback(ProductFeedback productFeedback) {

		String sql = query.giveFeedback(productFeedback);
		boolean isAdded = dbConnection.insertIntoDB(sql);
		return isAdded;	
	}

	public List<ProductFeedback> fetchFeedbackList(int productID) {
		String sql = query.fetchFeedbackList(productID);
		ArrayList<ProductFeedback> outList = dbConnection
				.fetchFeedbackList(sql);
		return outList;
	}

	public Shipping getShippingDetailsById(String shippingId) {
		String sql = query.getShippingDetailsById(shippingId);
		Shipping output = dbConnection.getShippingDetailsById(sql);
		return output;
	}

	public List<OrderDetail> getOrderList() {
	String sql = query.getOrderList();
	ArrayList<OrderDetail> outList = dbConnection
			.getOrderList(sql);
	System.out.println(outList.size());
	return outList;	
}

}
