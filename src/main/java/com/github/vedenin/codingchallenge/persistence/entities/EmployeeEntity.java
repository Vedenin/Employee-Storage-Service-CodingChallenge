package com.github.vedenin.codingchallenge.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by slava on 30.12.17.
 */
@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String email;
    private String address;
    @NotNull
    private BigDecimal salary;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private CompanyEntity company;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String surname, String email, String address, BigDecimal salary, CompanyEntity company) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
