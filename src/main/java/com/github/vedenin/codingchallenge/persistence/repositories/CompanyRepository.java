package com.github.vedenin.codingchallenge.persistence.repositories;

import com.github.vedenin.codingchallenge.persistence.entities.CompanyEntity;
import com.github.vedenin.codingchallenge.persistence.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by slava on 11.02.17.
 */
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {

}
