
package com.cigreja.employeewebsite.controllers;

import com.cigreja.employeewebsite.entities.User;
import java.util.HashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginController
 * @author Carlos Igreja
 * @since  Feb 21, 2016
 */
@Controller
@RequestMapping(value = "/Login")
public class LoginController {

    @RequestMapping(method = POST)
    public ModelAndView login(HttpServletRequest request, 
                              HttpServletResponse response){
        
        // model
        HashMap<String,String> model = new HashMap<>();
        
        // view
        String view;
        
        // check db for users
        User user = new User("testUser", "testPassword");
        
        // get user login information
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        // check for a user match
        if(user.getUsername().equals(username) 
                && user.getPassword().equals(password)){
            // add cookie to keep logged in
            Cookie cookie = new Cookie("userIdCookie", username);
            cookie.setMaxAge(60*60*24*365); // one year
            cookie.setPath("/"); // allow access to the entire app
            response.addCookie(cookie);
            model.put("errorMsg",""); // no errors
            view = "home";
        }
        else{
            model.put("errorMsg","invalid information"); // 
            view = "login";
        }

        return new ModelAndView(view, model);
    }
}
