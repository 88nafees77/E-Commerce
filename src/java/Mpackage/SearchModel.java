/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import databaseConnection.DbConn;
import java.io.PrintWriter;
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
public class SearchModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {
        try{
        PrintWriter out=response.getWriter();
        String search=request.getParameter("search");
            Connection connection=DbConn.getCon(ctx);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select Price,Product_Name from Electronics where Product_Name='"+search+"';");
            if(resultSet.next()){
                out.println(resultSet.getInt("Price"));
                out.println(resultSet.getString("Product_Name"));
                
            }else{
                out.println("Not Available");
            }
        }catch(Exception e){e.printStackTrace();}
    }

}
