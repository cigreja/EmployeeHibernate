
package com.cigreja.employeewebsite.controllers;

import com.cigreja.employeewebsite.dao.AddressDAO;
import com.cigreja.employeewebsite.dao.EmployeeDAO;
import com.cigreja.employeewebsite.entities.Address;
import com.cigreja.employeewebsite.entities.Employee;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
 * GetController
 * @author Carlos Igreja
 * @since  Feb 26, 2016
 */
@Controller
@RequestMapping(value = "/Get")
public class GetController {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    AddressDAO addressDAO;

    @RequestMapping(method = POST)
    public void get(HttpServletRequest request, HttpServletResponse response){

        PrintWriter out = null;

        // json object for test
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get posted information
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // check if user is in the database
        Employee employee = employeeDAO.getEmployee(firstName,lastName);

        if(employee != null){
            addressDAO.getAddresses(employee);
            List<Address> addresses = addressDAO.getAddresses(employee);
            if(!addresses.isEmpty()) {
                for (Address a : addresses) {
                    try {
                        jsonObject.put("id", a.getAddressID());
                        jsonObject.put("address", a.getAddress());
                        jsonArray.put(jsonObject);
                    } catch (JSONException ex) {
                        out.print("JSONException");
                    }
                }
                out.print(jsonArray);
            }
            else{
                out.print("There are no addresses for this employee");
            }
        }
        else{
            out.print("Employee doesn't exist");
        }
    }
}
