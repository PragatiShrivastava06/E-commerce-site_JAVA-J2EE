package com.scu.connecctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.scu.bean.Cart;
import com.scu.bean.Inventory;
import com.scu.bean.InventoryProductManagement;
import com.scu.bean.OrderDetail;
import com.scu.bean.OrderProductMapping;
import com.scu.bean.Product;
import com.scu.bean.ProductFeedback;
import com.scu.bean.Shipping;
import com.scu.bean.User;
import com.scu.transport.ResultTransport;

public class ScuDbConn {

	
	public boolean deleteFromDB(String sql) {
		Statement stmt;
		boolean isDeleted;
		try {
			stmt = DBConnection.getConnection().createStatement();
			stmt.execute(sql);
			isDeleted = true;
		} catch (Exception e) {
			isDeleted = false;
			System.out.println("Error at deleteFromDB() in ScuDbConn.java");
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean updateToDB(String sql) {
		Statement stmt;
		boolean isUpdate;
		try {
			stmt = DBConnection.getConnection().createStatement();
			stmt.executeUpdate(sql);
			isUpdate = true;
		} catch (Exception e) {
			isUpdate = false;
			System.out.println("Error at updateToDB() in ScuDbConn.java");
			e.printStackTrace();
		}
		return isUpdate;
	}

	public boolean insertIntoDB(String sql) {
		Statement stmt;
		boolean isInsert;
		try {
			stmt = DBConnection.getConnection().createStatement();
			stmt.execute(sql);
			isInsert = true;
		} catch (Exception e) {
			isInsert = false;
			System.out.println("Error at insertIntoDB() in ScuDbConn.java");
			//e.printStackTrace();
		}
		return isInsert;
	}

	public ArrayList<ResultTransport> getProductForSearch(String sql) {
		ArrayList<ResultTransport> outList = new ArrayList<ResultTransport>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ResultTransport tempPro = new ResultTransport();
				tempPro.setProductName(rs.getString("PRODUCTNAME"));
				tempPro.setProductID(rs.getString("PRODUCTID"));
				tempPro.setPrice(rs.getInt("PRICE"));
				tempPro.setAuthor(rs.getString("AUTHOR"));
				outList.add(tempPro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	public Product getProductFromSql(String sql) {
		Product tempPro = new Product();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				tempPro.setProductName(rs.getString("PRODUCTNAME"));
				tempPro.setProductID(rs.getString("PRODUCTID"));
				tempPro.setPrice(rs.getInt("PRICE"));
				tempPro.setAuthor(rs.getString("AUTHOR"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempPro;
	}

	public User getUserFromSql(String sql) {
		User tempUser = new User();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int tmp = rs.getInt("ISADMIN");
				if (tmp > 0) {
					tempUser.setAdmin(true);
				} else {
					tempUser.setAdmin(false);
				}
				tempUser.setUserName(rs.getString("USERNAME"));
				tempUser.setCity(rs.getString("CITY"));
				tempUser.setUserID(rs.getString("USERID"));
				tempUser.setPhoneNumber(rs.getInt("PHONENUMBER"));
				tempUser.setMobileNumber(rs.getInt("MOBILENUMBER"));
				tempUser.setEmailID(rs.getString("EMAILID"));
				tempUser.setPassword(rs.getString("PASSWORD"));
				tempUser.setStreet(rs.getString("STREET"));
				tempUser.setState(rs.getString("SATATE"));

				// print the results
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempUser;
	}

	public String getValueFromSql(String sql) {
		String output = null;
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				output = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	public ArrayList<Cart> getCartListByUser(String sql) {
		ArrayList<Cart> outList = new ArrayList<Cart>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Cart cartiteam = new Cart();
				cartiteam.setProductName(rs.getString("PRODUCTNAME"));
				cartiteam.setProductId(rs.getString("PRODUCTID"));
				cartiteam.setUserId(rs.getString("USERID"));
				cartiteam.setQuantity(rs.getInt("QTY"));
				// #TODO
				cartiteam.setPrice(rs.getInt("PRICE"));
				// cartiteam.setAuthor(rs.getString("AUTHOR"));

				outList.add(cartiteam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	public Map<String, String> getKeyValueFromSql(String sqlavailability) {

		Map<String, String> output = new HashMap<String, String>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlavailability);
			while (rs.next()) {
				output.put(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;

	}

	public ArrayList<Inventory> getinventories(String sql) {
		ArrayList<Inventory> outList = new ArrayList<Inventory>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId((rs.getLong("INVENTORYID")));
				inventory.setInventoryLocation(rs
						.getString("INVENTORY_LOCATION"));
				outList.add(inventory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	public ArrayList<InventoryProductManagement> getinvProList(String sql) {
		ArrayList<InventoryProductManagement> outList = new ArrayList<InventoryProductManagement>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				InventoryProductManagement inventory = new InventoryProductManagement();
				inventory.setInventoryId((rs.getLong("INVENTORYID")));
				inventory.setProductId(rs.getLong("PRODUCTID"));
				inventory.setProductQuantity((rs.getInt("PRODUCT_QUANTITY")));
				outList.add(inventory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	public InventoryProductManagement getInventoryProductManagementFromSql(
			String sql) {
		InventoryProductManagement tempObj = new InventoryProductManagement();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				tempObj.setInventoryId((rs.getLong("INVENTORYID")));
				tempObj.setProductId(rs.getLong("PRODUCTID"));
				tempObj.setProductQuantity((rs.getInt("PRODUCT_QUANTITY")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempObj;
	}

	public ArrayList<OrderDetail> getOrderList(String sql) {
		ArrayList<OrderDetail> outList = new ArrayList<OrderDetail>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				OrderDetail tempObj = new OrderDetail();
				tempObj.setCreditid(rs.getString("CREDITID"));
				tempObj.setDeliveryDate(rs.getString("DELIVERYDATE"));
				tempObj.setOrderID(rs.getInt("ORDERID"));
				tempObj.setOrderDate(rs.getString("ORDERDATE"));
				tempObj.setShippingId(rs.getInt("SHIPPINGID"));
				tempObj.setUserId(rs.getString("USERID"));
				outList.add(tempObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	public ArrayList<OrderProductMapping> getOrderProductMappingList(String sql) {
		ArrayList<OrderProductMapping> outList = new ArrayList<OrderProductMapping>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				OrderProductMapping tempObj = new OrderProductMapping();
				tempObj.setProductId(rs.getLong("PRODUCTID"));
				tempObj.setOrderId(rs.getInt("ORDERID"));
				tempObj.setQuntity(rs.getInt("QUANTITY"));
				tempObj.setTotalPrice(rs.getLong("TOTAL_PRICE"));
				tempObj.setProductName(rs.getString("PRODUCTNAME"));
				outList.add(tempObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	public ArrayList<ProductFeedback> fetchFeedbackList(String sql) {
		ArrayList<ProductFeedback> outList = new ArrayList<ProductFeedback>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ProductFeedback tempObj = new ProductFeedback();
				tempObj.setProductId(rs.getLong("PRODUCTID"));
				tempObj.setUserId(rs.getString("USERID"));
				tempObj.setReview(rs.getString("REVIEW"));
				tempObj.setRating(rs.getInt("RATING"));
				
				outList.add(tempObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	public Shipping getShippingDetailsById(String sql) {
		Shipping tempObj = new Shipping();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				tempObj.setShippingId(rs.getString("SHIPPINGID"));
				tempObj.setDeliverCity(rs.getString("DELIVERCITY"));
				tempObj.setDeliverState(rs.getString("DELIVERSTATE"));
				tempObj.setDeliverStreet(rs.getString("DELIVERSTREET"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempObj;
	}
	
	public ResultSet getResultSet(String sql) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "admin";
		String password = "admin123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		return rs;
	}

}
