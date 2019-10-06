/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerationService;

import databaseConnection.DbConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import javax.servlet.ServletContext;
import utility.MailSender;

/**
 *
 * @author nafees
 */
public class RegisterService {

    public static boolean register(UserService userService, ServletContext ctx, String ucode) throws SQLException {
        Connection connection = DbConn.getCon(ctx);
        PreparedStatement pr = connection.prepareStatement("insert into user_master values(?,?,?,?,?)");
        pr.setString(1, userService.getFirstname());
        pr.setString(2, userService.getLastname());
        pr.setString(3, userService.getPhone());
        pr.setInt(4, 1);
        pr.setString(5, "NULL");
        pr.execute();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into login values(?,?,?,?)");
        preparedStatement.setString(1, userService.getEmail());
        preparedStatement.setString(2, userService.getPassword());
        preparedStatement.setInt(3, userService.getStatus());
        preparedStatement.setString(4, userService.getPhone());
        preparedStatement.execute();
        PreparedStatement preparedStatement1 = connection.prepareStatement("insert into mail_code values(?,?)");
        preparedStatement1.setString(1, userService.getEmail());
        preparedStatement1.setString(2, ucode);
        preparedStatement1.execute();

        return true;

    }

}
