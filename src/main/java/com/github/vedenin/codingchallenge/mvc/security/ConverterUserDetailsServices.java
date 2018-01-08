package com.github.vedenin.codingchallenge.mvc.security;

import com.github.vedenin.codingchallenge.persistence.entities.AdminEntity;
import com.github.vedenin.codingchallenge.persistence.repositories.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by slava on 11.02.17.
 */
@Service
public class ConverterUserDetailsServices implements UserDetailsService {
    @Inject
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminEntity adminEntity = adminRepository.findByUserName(s);
        if(adminEntity == null) {
            throw new UsernameNotFoundException(s);
        } else {
            return adminEntity;
        }
    }
}
