package com.github.vedenin.codingchallenge;

import com.github.vedenin.codingchallenge.persistence.entities.AdminEntity;
import com.github.vedenin.codingchallenge.persistence.entities.CompanyEntity;
import com.github.vedenin.codingchallenge.persistence.entities.EmployeeEntity;
import com.github.vedenin.codingchallenge.persistence.repositories.AdminRepository;
import com.github.vedenin.codingchallenge.persistence.repositories.CompanyRepository;
import com.github.vedenin.codingchallenge.persistence.repositories.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        fillEmployeeDatabase(context);
    }


    /**
     * Just for prototype.
     *
     * @param context - Application context.
     */
    private static void fillEmployeeDatabase(ApplicationContext context) {
        EmployeeRepository employeeRepository = context.getBean(
                EmployeeRepository.class);
        CompanyEntity company1 = new CompanyEntity("Google");
        CompanyEntity company2 = new CompanyEntity("Facebook");
        CompanyRepository companyRepository = context.getBean(CompanyRepository.class);
        companyRepository.save(
                Arrays.asList(
                        company1, company2
                )
        );
        employeeRepository.save(
                Arrays.asList(
                        new EmployeeEntity(
                                "Huckleberry", "Finn", "finn@test.com", "Germany", new BigDecimal(50000), company1
                        ),
                        new EmployeeEntity(
                                "Tom", "Sawyer", "tom@test.com", "Germany", new BigDecimal(55000), company2
                        ),
                        new EmployeeEntity(
                                "Harry", "Potter", "poter@test.com", "Germany", new BigDecimal(65000), company1
                        ),
                        new EmployeeEntity(
                                "Hermione", "Granger", "hermione@test.com", "Germany", new BigDecimal(65000), company2
                        )
                )
        );
        AdminRepository adminRepository = context.getBean(AdminRepository.class);
        adminRepository.save(
                Collections.singletonList(
                        new AdminEntity(
                                "111", "1", "", "", "test@test.com", "01/01/2015",
                                "443083", "", "", true, true, true, true
                        )
                )
        );
    }
}
