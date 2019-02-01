/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sergio
 */
public class JdbcTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:mysql://192.168.1.122:3306/classicmodels";
            String user = "superadmin";
            String password = "secret";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ... 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
