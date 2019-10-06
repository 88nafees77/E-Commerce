/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mpackage;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nafees
 */
public interface ModelInterface {
    void requestProcessor(HttpServletRequest request,HttpServletResponse response,ServletContext ctx);
   
}
