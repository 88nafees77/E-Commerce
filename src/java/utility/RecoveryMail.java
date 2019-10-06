/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author nafees
 */
public class RecoveryMail {

    public boolean sendMail(String email, String ucode) {
        String from = "verify.email090@gmail.com";
        final String username = "verify.email090@gmail.com";
        final String password = "nafees@123";
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }

        });
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            msg.setSubject("forget password");
            msg.setText("http://localhost:8080/E-Commerce/fc?type=model&page=Recovery&email=" + email + "&code=" + ucode);
            Transport.send(msg);

        } catch (Exception c) {
            c.printStackTrace();
        }
        return true;

    }
}
