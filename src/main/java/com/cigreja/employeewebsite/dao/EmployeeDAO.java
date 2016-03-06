
package com.cigreja.employeewebsite.dao;

import com.cigreja.employeewebsite.entities.Address;
import com.cigreja.employeewebsite.entities.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeHibernateJpaRepository
 * @author Carlos Igreja
 * @since  Feb 19, 2016
 */
@Repository
@Transactional
public class EmployeeDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Session session(){
        return sessionFactory.getCurrentSession();
    }

    public Employee getEmployee(String firstName, String lastName){
        Query query = session().createQuery("from Employee "
                                         + "where FIRST_NAME =:firstName "
                                         + "and LAST_NAME =:lastName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        List employees = query.list();
        if (employees.isEmpty()) {
            return new Employee(firstName,lastName);
        } else {
            return (Employee) employees.get(0);
        }
    }

    public List<Address> getAddresses(Employee employee){

        List<Address> addresses = new ArrayList<>();
        return addresses;
    }

    public boolean addAddress(Employee employee, Address address){
        employee.getAddresses().add(address);
        address.getEmployees().add(employee);
        return true;
    }
}
