package com.github.vedenin.codingchallenge.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by slava on 30.12.17.
 */
@Entity
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String Name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public CompanyEntity(String name) {
        Name = name;
    }

    public CompanyEntity() {
    }
}
