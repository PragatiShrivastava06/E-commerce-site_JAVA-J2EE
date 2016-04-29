package com.scu.dbsql;

import java.util.List;

import com.scu.bean.Cart;
import com.scu.bean.CreditCardDetail;
import com.scu.bean.InventoryProductManagement;
import com.scu.bean.Product;
import com.scu.bean.ProductFeedback;
import com.scu.bean.Shipping;
import com.scu.bean.User;
import com.scu.transport.SearchTransport;

public class SelectQueries {
	public String createSqlForSearch(SearchTransport transport) {

		String sql = "SELECT PRODUCTNAME,PRODUCTID,PRICE, AUTHOR FROM PRODUCT ";

		String whereclause = "";

		if (transport.getProductName() != null
				&& !"".equals(transport.getProductName())) {
			whereclause = " PRODUCTNAME LIKE '%" + transport.getProductName()
					+ "%' ";
		}
		if (transport.getProductID() != null
				&& !"".equals(transport.getProductID())) {
			if (!"".equals(whereclause)) {
				whereclause = whereclause + " AND ";
			}
			whereclause = whereclause + " PRODUCTID LIKE '%"
					+ transport.getProductID() + "%' ";
		}
		if (transport.getAuthor() != null && !"".equals(transport.getAuthor())) {
			if (!"".equals(whereclause)) {
				whereclause = whereclause + " AND ";
			}
			whereclause = whereclause + " AUTHOR LIKE '%"
					+ transport.getAuthor() + "%' ";
		}

		if (transport.getPriceFrom() != null
				&& !"".equals(transport.getPriceFrom())) {
			if (!"".equals(whereclause)) {
				whereclause = whereclause + " AND ";
			}
			whereclause = whereclause + " PRICE >= " + transport.getPriceFrom()
					+ " ";
		}

		if (transport.getPriceTo() != null
				&& !"".equals(transport.getPriceTo())) {
			if (!"".equals(whereclause)) {
				whereclause = whereclause + " AND ";
			}
			whereclause = whereclause + " PRICE <= " + transport.getPriceTo()
					+ " ";
		}
		if (!"".equals(whereclause)) {
			sql = sql + " WHERE " + whereclause + ";";
		} else {
			sql = sql + ";";
		}
		System.out.println(sql);
		return sql;
	}

	public String createSqlForAddProduct(Product transport) {

		String sql = "INSERT INTO PRODUCT (PRODUCTNAME, PRICE, AUTHOR) VALUES (";
		String valueclause = "";

		if (transport.getProductName() != null
				&& !"".equals(transport.getProductName())) {
			valueclause = valueclause + "'" + transport.getProductName()
					+ "' ,";
		} else {
			valueclause = valueclause + "'' ,";
		}

		if (transport.getPrice() > 0) {
			if (!"".equals(valueclause)) {
				valueclause = valueclause + transport.getPrice() + ",";
			} else
				valueclause = valueclause + "0,";
		}

		if (transport.getAuthor() != null && !"".equals(transport.getAuthor())) {
			valueclause = valueclause + "'" + transport.getAuthor() + "'";
		} else {
			valueclause = valueclause + "''";
		}

		if (!"".equals(valueclause)) {
			sql = sql + valueclause + ");";
		}
		System.out.println(sql);
		return sql;
	}

	public String createSqlForDeleteProductById(String idToDelete) {
		String sql = "DELETE FROM PRODUCT WHERE PRODUCTID in (" + idToDelete
				+ ");";
		System.out.println(sql);
		return sql;

	}

	public String createSqlUpdateProduct(Product product) {
		String sql = "Update Product set PRODUCTNAME='"
				+ product.getProductName() + "',PRICE=" + product.getPrice()
				+ ",AUTHOR='" + product.getAuthor() + "' WHERE PRODUCTID="
				+ product.getProductID() + ";";
		System.out.println(sql);
		return sql;
	}

	public String getProductByID(int productID) {
		String sql = "SELECT PRODUCTNAME,PRODUCTID,PRICE,AUTHOR FROM PRODUCT where PRODUCTID="
				+ productID + ";";

		System.out.println(sql);
		return sql;
	}

	public String createSqlForAddUser(User transport) {

		String sql = "INSERT INTO USER (ISADMIN,USERID,USERNAME,PASSWORD,EMAILID,PHONENUMBER,MOBILENUMBER,STREET,CITY,STATE) VALUES (";
		String valueclause = "";

		if (transport.isAdmin()) {
			valueclause = valueclause + "1 ,";
		} else {
			valueclause = valueclause + "0 ,";
		}

		if (transport.getUserID() != null && !"".equals(transport.getUserID())) {
			valueclause = valueclause + "'" + transport.getUserID() + "',";
		} else {
			valueclause = valueclause + "'NeedToModifyUserID',";
		}
		if (transport.getUserName() != null
				&& !"".equals(transport.getUserName())) {
			valueclause = valueclause + "'" + transport.getUserName() + "',";
		} else {
			valueclause = valueclause + "'UserName',";
		}
		if (transport.getPassword() != null
				&& !"".equals(transport.getPassword())) {
			valueclause = valueclause + "'" + transport.getPassword() + "',";
		} else {
			valueclause = valueclause + "'Changeme@123',";
		}
		if (transport.getEmailID() != null
				&& !"".equals(transport.getEmailID())) {
			valueclause = valueclause + "'" + transport.getEmailID() + "',";
		} else {
			valueclause = valueclause + "'0',";
		}
		if (transport.getPhoneNumber() > 0) {
			valueclause = valueclause + "'" + transport.getPhoneNumber() + "',";
		} else {
			valueclause = valueclause + "'',";
		}
		if (transport.getMobileNumber() > 0) {
			valueclause = valueclause + "'" + transport.getMobileNumber()
					+ "',";
		} else {
			valueclause = valueclause + "'',";
		}
		if (transport.getStreet() != null && !"".equals(transport.getStreet())) {
			valueclause = valueclause + "'" + transport.getStreet() + "',";
		} else {
			valueclause = valueclause + "'',";
		}
		if (transport.getCity() != null && !"".equals(transport.getCity())) {
			valueclause = valueclause + "'" + transport.getCity() + "',";
		} else {
			valueclause = valueclause + "'',";
		}
		if (transport.getState() != null && !"".equals(transport.getState())) {
			valueclause = valueclause + "'" + transport.getState() + "'";
		} else {
			valueclause = valueclause + "''";
		}

		sql = sql + valueclause + ");";
		System.out.println(sql);
		return sql;
	}

	public String createSqlForDeleteUserById(String idToDelete) {
		String sql = "DELETE FROM USER WHERE USERID= '" + idToDelete + "' ;";
		System.out.println(sql);
		return sql;

	}

	public String createSqlUpdateUser(User user) {
		int isAdmintmp = 0;
		if (user.isAdmin()) {
			isAdmintmp = 1;
		}
		String sql = "Update User set ISADMIN='" + isAdmintmp + "',USERID='"
				+ user.getUserID() + "',USERNAME='" + user.getUserName() + "',"
				+ "EMAILID='" + user.getEmailID() + "',PHONENUMBER='"
				+ user.getPhoneNumber() + "',MOBILENUMBER='"
				+ user.getMobileNumber() + "',STREET='" + user.getStreet()
				+ "',CITY='" + user.getCity() + "',STATE='" + user.getState()
				+ "' WHERE USERID=" + user.getUserID() + ";";
		System.out.println(sql);
		return sql;
	}

	public String getUserByID(String userID) {
		String sql = "SELECT ISADMIN,USERID,USERNAME,PASSWORD,EMAILID,PHONENUMBER,MOBILENUMBER,STREET,CITY,STATE FROM USER where USERID="
				+ userID + ";";
		System.out.println(sql);
		return sql;
	}

	public String getPasswordByUserId(String userID) {
		String sql = "SELECT PASSWORD FROM USER where USERID='" + userID + "';";
		System.out.println(sql);
		return sql;
	}

	public String insertIntoCart(String productIds, String userId) {
		String sql = "INSERT INTO SHOPPING_CART ( USERID, PRODUCTID, QUANTITY ) VALUES";
		String valueclause = "";
		String[] productIdArray = productIds.split(",");
		for (String prodcutId : productIdArray) {
			// If block is for first record where we do not need , in front.
			if (!"".equals(valueclause)) {
				valueclause = valueclause + ",";
			}
			valueclause = valueclause + "('" + userId + "'," + prodcutId + ","
					+ 1 + ")";
		}
		if (!"".equals(valueclause)) {
			sql = sql + valueclause + ";";
		}
		System.out.println(sql);
		return sql;
	}

	public String getCartListByUser(String userId) {
		String sql = "SELECT S.USERID,S.PRODUCTID,P.PRODUCTNAME,P.PRICE, SUM(QUANTITY) QTY FROM SHOPPING_CART S INNER JOIN PRODUCT P ON S.PRODUCTID=P.PRODUCTID WHERE S.USERID='"
				+ userId + "' GROUP BY 1,2,3 ;";
		System.out.println(sql);
		return sql;
	}

	public String getIsUserAnAdmin(String userId) {
		String sql = "SELECT ISADMIN FROM User where USERID='" + userId + "';";
		System.out.println(sql);
		return sql;
	}

	public String createSqlForRemoveFromCart(String selectedIDs, String userId) {
		String sql = "DELETE FROM SHOPPING_CART WHERE USERID = '" + userId
				+ "' and PRODUCTID in (" + selectedIDs + ");";
		System.out.println(sql);
		return sql;

	}

	public String createSqlToValidateInventory(int productid, int quantity) {
		String sql = "SELECT CASE WHEN PRODUCT_QUANTITY >= "
				+ quantity
				+ " THEN '1' WHEN PRODUCT_QUANTITY < "
				+ quantity
				+ " THEN 'O' END AS \"QUANTITY_NOT_AVAILABLE \" FROM INVENTORY_PRODUCT_MANAGEMENT WHERE PRODUCTID= "
				+ productid
				+ " WHERE UPDATE  INVENTORY_PRODUCT_MANAGEMENT PRODUCT_QUANTITY=PRODUCT_QUANTITY-"
				+ quantity + " WHERE PRODUCTID=" + productid
				+ " AND PRODUCT_QUANTITY >= " + quantity + ";";
		System.out.println(sql);
		return sql;
	}

	public String getPrdocutCountSql(String productid) {
		String sql = " SELECT PRODUCTID , PRODUCT_QUANTITY FROM INVENTORY_PRODUCT_MANAGEMENT where PRODUCTID in ("
				+ productid + ");";
		System.out.println(sql);
		return sql;
	}

	public String createSqlToUpdateInventory(String productid, long quantity) {

		String sql = "UPDATE  INVENTORY_PRODUCT_MANAGEMENT SET  PRODUCT_QUANTITY=PRODUCT_QUANTITY-"
				+ quantity
				+ " WHERE PRODUCTID="
				+ productid
				+ " AND PRODUCT_QUANTITY >=" + quantity + ";";
		System.out.println(sql);
		return sql;
	}

	public String getClearCartSql(String userId) {
		String sql = "DELETE FROM SHOPPING_CART WHERE USERID = '" + userId
				+ "';";
		System.out.println(sql);
		return sql;
	}

	// Not in use need to remove
	public String insertintoOrderDetail(List<Cart> orderList, String userId) {
		String sql = "INSERT INTO ORDER_DETAIL ( USERID, PRODUCTID, QUANTITY ) VALUES";
		// String valueclause = "";
		// for (Cart cart : orderList) {
		// // If block is for first record where we do not need , in front.
		// if (!"".equals(valueclause)) {
		// valueclause = valueclause + ",";
		// }
		// valueclause = valueclause + "('" + userId + "'," + prodcutId + ","
		// + 1 + ")";
		// }
		// if (!"".equals(valueclause)) {
		// sql = sql + valueclause + ";";
		// }
		System.out.println(sql);
		return sql;
	}

	public String sqlForInsertViewdIteam(String userId, String productID) {
		String sql = "INSERT INTO VIEWED_ITEMS (USERID,  PRODUCTID) VALUES ('"
				+ userId + "','" + productID + "');";
		System.out.println(sql);
		return sql;
	}

	public String loadViewedIteam(String userId) {
		String sql = "SELECT PRODUCTNAME,PRODUCTID,PRICE, AUTHOR FROM PRODUCT where productid in (select productid from viewed_items where userId = '"
				+ userId + "');";
		System.out.println(sql);
		return sql;
	}

	public String addShippingAdress(Shipping shippingbean, String userId) {
		String sql = "INSERT INTO SHIPPING (USERID , DELIVERCITY,  DELIVERSTREET,  DELIVERSTATE) VALUES ('"
				+ userId
				+ "','"
				+ shippingbean.getDeliverCity()
				+ "','"
				+ shippingbean.getDeliverStreet()
				+ "','"
				+ shippingbean.getDeliverState() + "');";
		System.out.println(sql);
		return sql;
	}

	public String getShippingId() {
		return "SELECT MAX(SHIPPINGID) FROM SHIPPING;";
	}

	public String addCCdetail(CreditCardDetail creditDetail, String userId) {
		String sql = "INSERT INTO CREDIT_DETAILS (Creditid,USERID,CVV,EXPIRY_DATE,CREDIT_USERNAME) VALUES ('"
				+ creditDetail.getCreditCardNumber()
				+ "','"
				+ userId
				+ "','"
				+ creditDetail.getCvv()
				+ "','"
				+ creditDetail.getExpiryDate()
				+ "','" + creditDetail.getCreditUserName() + "');";
		System.out.println(sql);
		return sql;
	}

	public String createOrder(String creditCardNumber, String userId,
			String shippingId) {
		String sql = "INSERT INTO ORDER_DETAIL (USERID,ORDERDATE,DELIVERYDATE,CREDITID,SHIPPINGID) VALUES ('"
				+ userId
				+ "',CURRENT_DATE,CURRENT_DATE+5,'"
				+ creditCardNumber
				+ "'," + shippingId + ");";
		System.out.println(sql);
		return sql;
	}

	public String getOrderDetailId() {
		return "SELECT MAX(ORDERID) FROM ORDER_DETAIL;";
	}

	public String addOrderProductMapping(String productId, String orderId,
			long quantity, int price) {
		String sql = "INSERT INTO ORDER_PRODUCT_MAPPING (ORDERID,PRODUCTID,QUANTITY) VALUES ('"
				+ orderId + "','" + productId + "'," + quantity + ");";
		System.out.println(sql);
		return sql;
	}

	public String getinventories() {
		String sql = "SELECT INVENTORYID, INVENTORY_LOCATION FROM INVENTORY;";
		System.out.println(sql);
		return sql;
	}

	public String getinvProList(String inventoryId) {
		String sql = "SELECT PRODUCTID, INVENTORYID, PRODUCT_QUANTITY FROM INVENTORY_PRODUCT_MANAGEMENT WHERE INVENTORYID = "
				+ inventoryId + ";";
		System.out.println(sql);
		return sql;
	}

	public String createSqlForRemoveFromInv(String selectedIDs,
			String inventoryId) {
		String sql = "DELETE FROM INVENTORY_PRODUCT_MANAGEMENT WHERE INVENTORYID = '"
				+ inventoryId + "' and PRODUCTID in (" + selectedIDs + ");";
		System.out.println(sql);
		return sql;
	}

	public String getInventoryProductManagement(String inventoryId,
			String productId) {
		String sql = "SELECT INVENTORYID, PRODUCT_QUANTITY, PRODUCTID FROM INVENTORY_PRODUCT_MANAGEMENT WHERE PRODUCTID = '"
				+ productId + "' AND INVENTORYID = '" + inventoryId + "' ;";
		System.out.println(sql);
		return sql;
	}

	public String sqlForInsertInvPro(InventoryProductManagement selectedMap) {
		String sql = "INSERT INTO INVENTORY_PRODUCT_MANAGEMENT (INVENTORYID,  PRODUCTID, PRODUCT_QUANTITY) VALUES ("
				+ selectedMap.getInventoryId()
				+ ","
				+ selectedMap.getProductId()
				+ ","
				+ selectedMap.getProductQuantity() + ");";
		System.out.println(sql);
		return sql;
	}

	public String sqlForUpdateInvPro(InventoryProductManagement selectedMap) {
		String sql = "Update INVENTORY_PRODUCT_MANAGEMENT set PRODUCT_QUANTITY="
				+ selectedMap.getProductQuantity()
				+ " WHERE PRODUCTID="
				+ selectedMap.getProductId()
				+ " AND INVENTORYID="
				+ selectedMap.getInventoryId() + ";";
		System.out.println(sql);
		return sql;
	}

	public String getOrderListByUserId(String userId) {
		String sql = "SELECT ORDERID, USERID, ORDERDATE,DELIVERYDATE, CREDITID, SHIPPINGID FROM ORDER_DETAIL  WHERE USERID = '"
				+ userId + "' ;";
		System.out.println(sql);
		return sql;
	}

	public String getorderproductmappingByOrderId(String orderId) {
		String sql = "SELECT S.ORDERID,S.PRODUCTID,P.PRODUCTNAME,S.QUANTITY, (S.QUANTITY * P.PRICE) AS TOTAL_PRICE  FROM ORDER_PRODUCT_MAPPING S INNER JOIN PRODUCT P ON S.PRODUCTID=P.PRODUCTID WHERE  ORDERID = "
				+ orderId + " ;";
		System.out.println(sql);
		return sql;
	}

	public String giveFeedback(ProductFeedback productFeedback) {
		String sql = "INSERT INTO PRODUCT_FEEDBACK (USERID, PRODUCTID, REVIEW, RATING) VALUES ('"
				+ productFeedback.getUserId()
				+ "','"
				+ productFeedback.getProductId()
				+ "','"
				+ productFeedback.getReview()
				+ "','"
				+ productFeedback.getRating() + "');";
		System.out.println(sql);
		return sql;
	}

	public String fetchFeedbackList(int productID) {
		String sql = "select PRODUCTID,USERID,RATING,REVIEW from product_feedback where PRODUCTID="
				+ productID + ";";
		System.out.println(sql);
		return sql;
	}

	public String getShippingDetailsById(String shippingId) {

		String sql = "SELECT SHIPPINGID, DELIVERCITY, DELIVERSTREET, DELIVERSTATE FROM SHIPPING WHERE SHIPPINGID = "
				+ shippingId + ";";
		System.out.println(sql);
		return sql;
	}

	public String getOrderList() {
		String sql = "SELECT ORDERID, USERID, ORDERDATE,DELIVERYDATE, CREDITID, SHIPPINGID FROM ORDER_DETAIL  WHERE ORDERDATE > (CURRENT_DATE -30);";
		System.out.println(sql);
		return sql;
	}

}