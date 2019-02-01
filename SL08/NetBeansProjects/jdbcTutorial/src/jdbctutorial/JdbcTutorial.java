/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbctutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sergio
 */
public class JdbcTutorial {

    public static void main(String[] args) {
        // 
        String sql = "select customerName,phone,country " +
                     "from customers";
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
           
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("customerName") + "\t" + 
                                   rs.getString("phone")  + "\t" +
                                   rs.getString("country"));
                    
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
