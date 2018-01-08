package com.github.vedenin.codingchallenge.mvc.controler;

import com.github.vedenin.codingchallenge.persistence.entities.*;
import com.github.vedenin.codingchallenge.persistence.repositories.*;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by slava on 13.02.17.
 */
public abstract class EmployeeRestController  extends WebMvcConfigurerAdapter {

    protected abstract EmployeeRepository getEmployeeRepository();

    protected abstract CompanyRepository getCompanyRepository();



    @RequestMapping(value = "/rest/companies/{id}/employees", method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeEntity> getEmployeesForCompany(@PathVariable("id") Long id) {
        CompanyEntity companyEntity = getCompany(id);
        return getEmployeeRepository().findByCompany(companyEntity);
    }

    @RequestMapping(value = "/rest/companies/{id}/salary/avg", method = RequestMethod.GET)
    @ResponseBody
    public Double getAvgSalaryForCompany(@PathVariable("id") Long id) {
        CompanyEntity companyEntity = getCompany(id);
        return getEmployeeRepository().getAverageSalaryByCompany(companyEntity);
    }

    @RequestMapping(value = "/rest/companies/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CompanyEntity getCompany(@PathVariable("id") Long id) {
        return  getCompanyRepository().findOne(id);
    }

    @RequestMapping(value = "/rest/companies", method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyEntity> getCompanies() {
        return Lists.newArrayList(getCompanyRepository().findAll());
    }

    @RequestMapping(value = "/rest/companies/{companyId}/employees/{id}", method = RequestMethod.GET)
    @ResponseBody
    public EmployeeEntity getEmployee(@PathVariable("id") Long id,
                                      @PathVariable("companyId") Long companyId) {
        return getEmployeeRepository().findOne(id);
    }

    @RequestMapping(value = "/rest/companies/{companyId}/employees", method = RequestMethod.POST)
    @ResponseBody
    public EmployeeEntity addEmployee(@PathVariable("companyId") Long companyId,
                                      EmployeeEntity entity) {
        entity.setCompany(getCompany(companyId));
        getEmployeeRepository().save(Collections.singleton(entity));
        return entity;
    }

    @RequestMapping(value = "/rest/companies/{companyId}/employees/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public EmployeeEntity updateEmployee(
            @PathVariable("id") Long id,
            @PathVariable("companyId") Long companyId,
            EmployeeEntity entity) {
        entity.setCompany(getCompany(companyId));
        getEmployeeRepository().save(Collections.singleton(entity));
        return entity;
    }

    @RequestMapping(value = "/rest/companies/{companyId}/employees/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteEmployee(
            @PathVariable("id") Long id,
            @PathVariable("companyId") Long companyId) {
        getEmployeeRepository().delete(id);
    }

}

