
package com.cigreja.employeewebsite.controllers;

import com.cigreja.employeewebsite.business.User;
import java.util.HashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.servlet.ModelAndView;

/**
 * Dispatcher
 * @author Carlos Igreja
 * @since  Feb 18, 2016
 */
@Controller
@RequestMapping( value = "/")
public class Dispatcher {

    @RequestMapping(method = GET)
    public ModelAndView index(HttpServletRequest request){
        
        // get cookies and session
        Cookie[] cookies = request.getCookies();
        String cookieName = "userIdCookie";
        String cookieValue = "";
        HttpSession session = request.getSession();
        
        boolean cookieExists = false;
        for(Cookie c : cookies){
            if(c.getName().equals(cookieName)){
                cookieValue = c.getValue();
                session.setAttribute(cookieName, cookieValue);
                // get user
                User user = new User("testUser","testpw");
                request.setAttribute("user", user);
                cookieExists = true;
            }
        }
        
        String view = cookieExists?"home":"login";
        HashMap<String,String> model = new HashMap<>();
        model.put("navSelection", "addEmployee"); // default nav selection
        return new ModelAndView(view,model);
    }
}
