package com.gmail.yevgen.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Table(name = "stock.user_company")
public class UserCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Integer amount;

   @Column(name = "value", updatable = false)
   @Formula("amount*price")
    private Double value;

    @ManyToOne
    @JoinColumns ({
        @JoinColumn(name = "price", referencedColumnName = "price"),
        @JoinColumn(name = "code", referencedColumnName = "code")
    })
    private Company company;

    @ManyToOne
    @JoinColumn(name = "email")
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

//    public Company getCompanyCode() {
//        return companyCode;
//    }
//
//    public void setCompanyCode(Company code) {
//        this.companyCode = code;
//    }
//
//    public Company getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(Company price) {
//        this.unitPrice = price;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
