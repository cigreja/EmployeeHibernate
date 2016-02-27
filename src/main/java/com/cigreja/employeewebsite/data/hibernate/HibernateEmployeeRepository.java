
package com.cigreja.employeewebsite.data.hibernate;

import com.cigreja.employeewebsite.business.Address;
import com.cigreja.employeewebsite.business.Employee;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * HibernateEmployeeRepository
 * @author Carlos Igreja
 * @since  Feb 19, 2016
 */
@Repository
@Transactional
public class HibernateEmployeeRepository {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public Session session(){
        return sessionFactory.getCurrentSession();
    }
    
    public Employee getEmployee(String firstName, String lastName){
        Query query = session().createQuery("from Employee "
                                         + "where FIRST_NAME =:firstName "
                                         + "and LAST_NAME =:lastName");
        query.setString("firstName", firstName);
        query.setString("lastName", lastName);
        return (Employee)query.uniqueResult();
    }
    
    public void save(Employee employee, Address address){
        session().save(employee);
        session().save(address);
    }
   
    public boolean containsAddress(Employee employee, Address address){
        
        List<Address> addresses;
        addresses = employee.getAddresses();
            
        for(Address a : addresses){
            if(address.getAddress().equals(a.getAddress())){
                return true;
            }
        }
        return false;
    }
}
