/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import databaseConnection.DbConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nafees
 */
public class ValidateModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {
        try {

            String code = request.getParameter("code");

            Connection connection = DbConn.getCon(ctx);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select email from mail_code where ucode='" + code + "';");
            if (resultSet.next()) {

                String email = resultSet.getString("email");
                statement.executeUpdate("update login set status ='" + 1 + "' where email='" + email + "';");

               

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
