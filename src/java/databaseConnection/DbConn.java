/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author nafees
 */
public class DbConn {
    
    public static Connection getCon(ServletContext ctx) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection connection=DriverManager.getConnection(ctx.getInitParameter("url"),ctx.getInitParameter("username"),ctx.getInitParameter("password"));
        return connection;
        
    }
    
}
