/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import databaseConnection.DbConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nafees
 */
public class AddToCartModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {
        try {
            String cat="Electronics";
            System.out.println(cat);
            String pid=request.getParameter("pid");
            System.out.println(pid);
            Connection connection = DbConn.getCon(ctx);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Price,Product_Name,status from '"+cat+"' where Product_Id='"+pid+"';");
            if(resultSet.next()){
                System.out.println(resultSet.getString("Price"));
                System.out.println(resultSet.getString("Product_Name"));
                System.out.println(resultSet.getInt("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
