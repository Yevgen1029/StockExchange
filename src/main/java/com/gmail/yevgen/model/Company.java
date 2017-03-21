package com.gmail.yevgen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock.company")
public class Company implements Serializable {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price")
    private Double price;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companyCode")
//    private Set<UserCompany> productList1 = new HashSet<UserCompany>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<UserCompany> userCompanySet = new HashSet<UserCompany>(0);

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double unitPrice) {
        this.price = unitPrice;
    }
//
//    public Set<UserCompany> getProductList1() {
//        return productList1;
//    }
//
//    public void setProductList1(Set<UserCompany> productList1) {
//        this.productList1 = productList1;
//    }

    public Set<UserCompany> getUserCompanySet() {
        return userCompanySet;
    }

    public void setUserCompanySet(Set<UserCompany> productList) {
        this.userCompanySet = productList;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Company{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", userCompanySet=" + userCompanySet +
                '}';
    }
}
