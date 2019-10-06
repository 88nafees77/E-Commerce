/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import databaseConnection.DbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import registerationService.UserService;

/**
 *
 * @author nafees
 */
public class LoginModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {

        try {
            
            PrintWriter out = response.getWriter();
            System.out.println(request.getParameter("search"));
            UserService userService = new UserService();
            userService.setEmail(request.getParameter("email"));
            userService.setPassword(request.getParameter("pass"));
            System.out.println("login1");
            Connection connection = DbConn.getCon(ctx);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select password,status from login where(email='" + userService.getEmail() + "')");
            if (resultSet.next()) {
                String upass = resultSet.getString("password");
                int status = resultSet.getInt("status");
                System.out.println("login2");
                if (upass.equals(userService.getPassword())) {
                    if (status == 0) {
                        out.println("Not Verified");
                        
                    }
                    if (status == 1) {
                        out.println("verified");
                        HttpSession session = request.getSession(true);
                        session.setAttribute("email", userService.getEmail());
                        try {
                            request.getRequestDispatcher("/WEB-INF/pages/homepage_1.jsp").forward(request, response);
                        } catch (ServletException ex) {
                            ex.printStackTrace();
                        }
                        
                    }
                }
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
