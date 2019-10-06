/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import java.io.PrintWriter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import registerationService.RegisterService;
import registerationService.UserService;
import utility.MailSender;

/**
 *
 * @author nafees
 */
public class RegistrationModel implements ModelInterface {

    @Override
    public void requestProcessor(HttpServletRequest request, HttpServletResponse response,ServletContext ctx) {
        PrintWriter out = null;
        try {
            String ucode=UUID.randomUUID().toString();
            UserService userService = new UserService();
            userService.setUcode(ucode);
            userService.setEmail(request.getParameter("email"));
            userService.setPassword(request.getParameter("pass"));
            userService.setFirstname(request.getParameter("fname"));
            userService.setLastname(request.getParameter("lname"));
            userService.setPhone(request.getParameter("phone"));
           // userService.setCity(Integer.parseInt(request.getParameter("city")));
            boolean register = RegisterService.register(userService,ctx,ucode);
                MailSender ms=new MailSender();
                ms.sendMail(userService.getEmail(),ucode);
                request.getRequestDispatcher("/WEB-INF/pages/loginhome.jsp").forward(request, response);
            
        } catch (Exception ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //out.close();
        }
        
    }
}
