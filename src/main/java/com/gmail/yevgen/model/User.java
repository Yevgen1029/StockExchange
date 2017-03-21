package com.gmail.yevgen.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock.users")
public class User {

    @Column(name = "username", nullable = false)
    @NotEmpty(message = "This field can not be empty!")
    private String username;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "phonenumber")
    private Long phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "wallet")
    private BigDecimal wallet;

    @Column(name = "enabled")
    private Boolean enabled = true;

    @OneToMany(mappedBy = "user")
    private Set<UserRoles> userRoles = new HashSet<UserRoles>(0);

    @OneToMany(mappedBy = "user")
    private Set<UserCompany> companies = new HashSet<UserCompany>(0);


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.username = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public Set<UserCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<UserCompany> products) {
        this.companies = products;
    }
}
