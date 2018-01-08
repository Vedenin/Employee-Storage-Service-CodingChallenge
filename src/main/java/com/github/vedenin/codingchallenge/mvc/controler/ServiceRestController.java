package com.github.vedenin.codingchallenge.mvc.controler;

import com.github.vedenin.codingchallenge.persistence.entities.AdminEntity;
import com.github.vedenin.codingchallenge.persistence.entities.ErrorEntity;
import com.github.vedenin.codingchallenge.persistence.repositories.ErrorRepository;
import com.github.vedenin.codingchallenge.persistence.repositories.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by slava on 13.02.17.
 */
@RestController
public class ServiceRestController {
    private static final String ACCESS_KEY = "sg435jklj";

    @Inject
    AdminRepository adminRepository;
    @Inject
    ErrorRepository errorRepository;


    @RequestMapping(value = "/rest/user",  method = RequestMethod.GET)
    public ResponseEntity<List<AdminEntity>> getUsers(@RequestParam(value="access_key", defaultValue = "") String accessKey) {
        if(ACCESS_KEY.equals(accessKey)) {
            return ResponseEntity.ok(Lists.newArrayList(adminRepository.findAll()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @RequestMapping(value = "/rest/error",  method = RequestMethod.GET)
    public ResponseEntity<List<ErrorEntity>> getErrors(@RequestParam(value="access_key", defaultValue = "") String accessKey) {
        if(ACCESS_KEY.equals(accessKey)) {
            return ResponseEntity.ok(Lists.newArrayList(errorRepository.findAll()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
