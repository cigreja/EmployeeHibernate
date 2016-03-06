package com.cigreja.employeewebsite.dao;

import com.cigreja.employeewebsite.entities.Address;
import com.cigreja.employeewebsite.entities.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * AddressDAO
 * @author Carlos Igreja
 * @since  Feb 29, 2016
 */
@Repository
@Transactional
public class AddressDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Session session(){
        return sessionFactory.getCurrentSession();
    }

    public List<Address> getAddresses(Employee employee){

        int id = employee.getEmployeeID();
        Query query = session().createQuery("SELECT a " +
                "FROM Address a " +
                "JOIN a.employees e " +
                "WHERE e.employeeID =:id");
        query.setParameter("id",id);
        List<Address> addresses = query.list();
        return addresses;
    }

    public Address containsAddress(List<Address> addresses, Address address) {
        for(Address a : addresses){
            if(address.getAddress().equals(a.getAddress())){
                return a;
            }
        }
        session().save(address);
        return address;
    }

    public boolean addressExists(List<Address> addresses, Address address) {
        for(Address a : addresses){
            if(address.getAddress().equals(a.getAddress())){
                return true;
            }
        }
        return false;
    }

    public List<Address> getAddresses() {
        Query query = session().createQuery("from Address");
        return query.list();
    }
}
