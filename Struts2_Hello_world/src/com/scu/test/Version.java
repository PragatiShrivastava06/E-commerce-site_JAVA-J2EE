package com.scu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.scu.bean.Customer;

public class Version {

	public static void main(String[] args) {
		// TODO Auto-generated method 
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "admin";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs= st.executeQuery("Select count(*) from order_detail");
          //  rs = st.executeQuery("SELECT * FROM CUSTOMER");
          //  Customer cm = new Customer();
            while (rs.next()) {
                //cm.setId(rs.getString(1));
//            	String USERID = rs.getString("USERID");
//                String PASSWORD = rs.getString("PASSWORD");
//                String ORDERID = rs.getString("ORDERID");
//                String PHONE = rs.getString("PHONE");
//                String EMAIL = rs.getString("EMAIL");
//                String ADDRESS = rs.getString("ADDRESS");
//                 
                // print the results
//                System.out.format("%s, %s, %s, %s, %s, %s\n", USERID, PASSWORD, ORDERID, PHONE, EMAIL, ADDRESS);
            	System.out.println(rs.getString(1));
            }

        }
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
	}
	}
}
