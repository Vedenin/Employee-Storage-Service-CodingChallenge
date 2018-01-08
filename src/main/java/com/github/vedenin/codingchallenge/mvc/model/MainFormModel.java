package com.github.vedenin.codingchallenge.mvc.model;


import javax.validation.constraints.NotNull;

/**
 * Model for converter page
 *
 * Created by vvedenin on 2/8/2017.
 */
public class MainFormModel {
    @NotNull
    private Long company = 1L;

    public Long getCompany() {
        return company;
    }

    public void setCompany(Long company) {
        this.company = company;
    }
}
