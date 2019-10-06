/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import databaseConnection.DbConn;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nafees
 */
public class RecoveryModel implements ModelInterface {
    
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {
        try {
            
            String code = request.getParameter("code");
            
            Connection connection = DbConn.getCon(ctx);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select email from mail_code where otp='" + code + "';");
            if (resultSet.next()) {
                
                request.setAttribute("email", resultSet.getString("email"));
                request.getRequestDispatcher("/WEB-INF/pages/newPassword.jsp").forward(request, response);
                System.out.println(request.getAttribute("email").toString());
                
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(RecoveryModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RecoveryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
