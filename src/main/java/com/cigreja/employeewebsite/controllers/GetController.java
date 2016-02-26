
package com.cigreja.employeewebsite.controllers;

import com.cigreja.employeewebsite.business.Address;
import com.cigreja.employeewebsite.business.Employee;
import com.cigreja.employeewebsite.data.hibernate.HibernateEmployeeRepository;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;

/**
 * GetController
 * @author Carlos Igreja
 * @since  Feb 26, 2016
 */
@Controller
@RequestMapping(value = "/Get")
public class GetController {

    @Autowired
    HibernateEmployeeRepository repository;

    @RequestMapping(method = POST)
    public ModelAndView get(HttpServletRequest request){
        
        HashMap<String,Object> model = new HashMap<>();
        String view = "home";
            
        // get posted information
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        
        // check if user is in the database
        Employee employee = repository.getEmployee(firstName,lastName);
        if(employee != null){
            // get employee addresses
            List<Address> addresses = employee.getAddresses();
            model.put("addresses", addresses);
        }
        else{
            // display error employee doesn't exist
            model.put("getErrMsg", "Employee doesn't exist");
        }
        
        return new ModelAndView(view,model);
    }
}
