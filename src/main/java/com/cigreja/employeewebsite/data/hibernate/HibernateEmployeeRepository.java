
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
public class HibernateEmployeeRepository {
    
    @Autowired
    SessionFactory sessionFactory;
    
//    @Autowired
//    public HibernateEmployeeRepository(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }
    
//    public Session getSession(){
//        return sessionFactory.getCurrentSession();
//    }
    
    /* EMPLOYEE METHODS */
    
    @Transactional
    public Employee getEmployee(String firstName, String lastName){
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee "
                                         + "where FIRST_NAME =:firstName "
                                         + "and LAST_NAME =:lastName");
        query.setString("firstName", firstName);
        query.setString("lastName", lastName);
        Object o = query.uniqueResult();
        return(o == null)?null:(Employee)o;
    }
    
    @Transactional
    public void save(Employee employee){
        sessionFactory.getCurrentSession().save(employee);
    }
    
    @Transactional
    public void save(Address address){
        sessionFactory.getCurrentSession().save(address);
    }
    
    @Transactional
    public void save(Employee employee, Address address){
        sessionFactory.getCurrentSession().save(employee);
        sessionFactory.getCurrentSession().save(address);
    }
    
    @Transactional
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
