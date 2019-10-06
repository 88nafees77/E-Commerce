/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import databaseConnection.DbConn;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author nafees
 */
public class ImageUploadModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) {
        try {
            PrintWriter writer = response.getWriter();
            InputStream filecontent = null;
            final String path = "/home/nafees/Desktop/images/";
            final Part filepart = request.getPart("file");
            final String filename = getFileName(filepart);
            String str = filename.substring(filename.indexOf("."));
            HttpSession session = request.getSession();
            String email = session.getAttribute("email").toString();
            OutputStream output = null;
            output = new FileOutputStream(new File(path + File.separator + email + str));
            filecontent = filepart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                output.write(bytes, 0, read);
            }
            Connection connection = DbConn.getCon(ctx);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select phone from login where email='" + email + "';");
            if (resultSet.next()) {
                String phone = resultSet.getString("phone");
                statement.executeUpdate("update user_master set img_path='" + path+email+str + "' where phone= '" + phone + "';");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
