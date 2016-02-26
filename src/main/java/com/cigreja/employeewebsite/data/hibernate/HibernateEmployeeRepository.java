
package com.cigreja.employeewebsite.data.hibernate;

import com.cigreja.employeewebsite.business.Address;
import com.cigreja.employeewebsite.business.Employee;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * HibernateEmployeeRepository
 * @author Carlos Igreja
 * @since  Feb 19, 2016
 */
@Repository
public class HibernateEmployeeRepository {
    
    SessionFactory sessionFactory;
    Session session;
    
    @Autowired
    public HibernateEmployeeRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }
    
    public Session getSession(){
        return session;
    }
    
    /* EMPLOYEE METHODS */
    
    public Employee getEmployee(String firstName, String lastName){
        Query query = session.createQuery("from Employee "
                                         + "where FIRST_NAME =:firstName "
                                         + "and LAST_NAME =:lastName");
        query.setString("firstName", firstName);
        query.setString("lastName", lastName);
        Object o = query.uniqueResult();
        return(o == null)?null:(Employee)o;
    }
}
