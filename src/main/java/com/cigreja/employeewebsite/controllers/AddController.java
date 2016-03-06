
package com.cigreja.employeewebsite.controllers;

import com.cigreja.employeewebsite.dao.AddressDAO;
import com.cigreja.employeewebsite.dao.EmployeeDAO;
import com.cigreja.employeewebsite.entities.Address;
import com.cigreja.employeewebsite.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * AddController
 * @author Carlos Igreja
 * @since  Feb 21, 2016
 */
@Controller
@RequestMapping(value = "/Add")
public class AddController {
    
    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    AddressDAO addressDAO;

    @RequestMapping(method = POST)
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Response Writer
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();

        // Get Employee
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Employee employee = employeeDAO.getEmployee(firstName,lastName);

        // Get Address
        Address address = new Address(request.getParameter("address"));
        List<Address> allAddresses = addressDAO.getAddresses();
        address = addressDAO.containsAddress(allAddresses,address); // use existing

        // Check If Employee Address Already Exists
        List<Address> employeeAddresses = addressDAO.getAddresses(employee);
        if(!addressDAO.addressExists(employeeAddresses,address)){

            // Add Employee Address
            if(employeeDAO.addAddress(employee,address)){
                writer.print("Add successful!");
            }
            else{
                writer.print("Failed to add!");
            }
        }
        else{
            writer.print("Employee address already exists");
        }
    }
}
