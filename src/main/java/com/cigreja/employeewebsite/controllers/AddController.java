
package com.cigreja.employeewebsite.controllers;

import com.cigreja.employeewebsite.business.Address;
import com.cigreja.employeewebsite.business.Employee;
import com.cigreja.employeewebsite.data.hibernate.HibernateEmployeeRepository;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;

/**
 * AddController
 * @author Carlos Igreja
 * @since  Feb 21, 2016
 */
@Controller
@RequestMapping(value = "/Add")
public class AddController {
    
    @Autowired
    HibernateEmployeeRepository repository;

    @RequestMapping(method = POST)
    public ModelAndView add(HttpServletRequest request){
        
        HashMap<String,Object> model = new HashMap<>();
        String view = "home";
            
        // get posted information
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Address address = new Address(request.getParameter("address"));
        
        // check if user is already in the database
        Employee employee = repository.getEmployee(firstName,lastName);
        if(employee == null){
            System.out.println("employee == null");
            // create new employee
            employee = new Employee(firstName, lastName);
            employee.getAddresses().add(address);
            address.getEmployees().add(employee);
            repository.save(employee, address);
        }
        else{
            if(!repository.containsAddress(employee, address)){
                employee.getAddresses().add(address);
                address.getEmployees().add(employee);
                repository.save(employee, address);
            }
            else{
                // display error employee address already exists
                model.put("addErrMsg", "Employee address already exists");
            }
        }

        return new ModelAndView(view,model);
    }
}
