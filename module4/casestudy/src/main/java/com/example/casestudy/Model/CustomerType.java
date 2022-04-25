package com.example.casestudy.Model;

import javax.persistence.*;
import java.util.List;
@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    private String nameType;
    @OneToMany(mappedBy = "idCustomer")
    private List<Customer> customer;

    public CustomerType() {
    }

    public CustomerType(Long idType, String nameType, List<Customer> customer) {
        this.idType = idType;
        this.nameType = nameType;
        this.customer = customer;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
