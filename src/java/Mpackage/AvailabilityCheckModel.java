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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nafees
 */
public class AvailabilityCheckModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {
        try {
            Connection connection = DbConn.getCon(ctx);
            String email = request.getParameter("email");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select email from login where(email='"+email+"');");
            PrintWriter out=response.getWriter();
            if(resultSet.next()){
                out.println("<html><h style='color:red;'>User Already Exits</h></html>");
            }else{
                out.println("<html><h style='color:green;'>Available</h></html>");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    

}
