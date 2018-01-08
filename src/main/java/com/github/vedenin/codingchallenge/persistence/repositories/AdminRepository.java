package com.github.vedenin.codingchallenge.persistence.repositories;

import com.github.vedenin.codingchallenge.persistence.entities.AdminEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by slava on 11.02.17.
 */
public interface AdminRepository extends CrudRepository<AdminEntity, Long> {
    public AdminEntity findByUserName(String userName);
}
