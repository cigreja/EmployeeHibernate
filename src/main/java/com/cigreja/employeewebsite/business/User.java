
package com.cigreja.employeewebsite.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User
 * @author Carlos Igreja
 * @since  Feb 14, 2016
 */
//@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "User_ID")
    private int id;
    
    @Column(name = "Username")
    private String username;
    
    @Column(name = "Password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
