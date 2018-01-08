package com.github.vedenin.codingchallenge.persistence.repositories;

import com.github.vedenin.codingchallenge.persistence.entities.CompanyEntity;
import com.github.vedenin.codingchallenge.persistence.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by slava on 11.02.17.
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByCompany(CompanyEntity company);

    @Query(value = "SELECT avg(salary) from EmployeeEntity where company = ?1")
    Double getAverageSalaryByCompany(CompanyEntity company);

}
