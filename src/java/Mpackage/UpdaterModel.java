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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nafees
 */
public class UpdaterModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {
        try {

            String pass = request.getParameter("password1");
            String email = request.getParameter("email");
            Connection connection = DbConn.getCon(ctx);
            Statement statement = connection.createStatement();
            HttpSession session = request.getSession();
            System.out.println("helloo");
            int b = statement.executeUpdate("update login set password='" + pass + "' where email='" + email + "';");
            System.out.println("helloo after");
            if (b != 0) {
                System.out.println("password change");
                request.getRequestDispatcher("/WEB-INF/pages/newPassword.jsp").forward(request, response);

            } else {
                System.out.println("password not change");

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
