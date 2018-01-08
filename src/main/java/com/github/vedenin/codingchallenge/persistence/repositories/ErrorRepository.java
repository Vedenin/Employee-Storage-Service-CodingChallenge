package com.github.vedenin.codingchallenge.persistence.repositories;

import com.github.vedenin.codingchallenge.persistence.entities.ErrorEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by slava on 11.02.17.
 */
public interface ErrorRepository extends CrudRepository<ErrorEntity, Long> {
}
