
package com.cigreja.employeewebsite.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Address
 * @author Carlos Igreja
 * @since  Feb 21, 2016
 */
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private int addressID;
    
    private String address;

    @ManyToMany(mappedBy = "addresses",fetch = FetchType.LAZY)
    @Column(name = "EMPLOYEE", table = "Map")
    private List<Employee> employees = new ArrayList<>();

    // default zero argument constructor
    public Address(){
        this(null);
    }

    public Address(String address) {
        this.address = address;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
