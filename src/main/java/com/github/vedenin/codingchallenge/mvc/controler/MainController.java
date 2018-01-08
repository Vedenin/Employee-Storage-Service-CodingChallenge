package com.github.vedenin.codingchallenge.mvc.controler;

import com.github.vedenin.codingchallenge.mvc.model.MainFormModel;
import com.github.vedenin.codingchallenge.mvc.model.CountryService;
import com.github.vedenin.codingchallenge.persistence.entities.*;
import com.github.vedenin.codingchallenge.persistence.repositories.*;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import static com.github.vedenin.codingchallenge.mvc.Consts.*;

/*
* Controller that provide main page of Converter application
*/
@Controller
public class MainController extends EmployeeRestController {

    private static final String RESULT = "result";

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    @Inject
    private AdminRepository adminRepository;
    @Inject
    private CountryService countryService;
    @Inject
    private ErrorRepository errorRepository;
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private CompanyRepository companyRepository;

    @RequestMapping(LIST_URL)
    public String handleConverterForm(MainFormModel mainFormModel, Model model) {
        return getListFrom(mainFormModel.getCompany(), model);
    }

    private String getListFrom(Long companyId, Model model) {
        try {
            model.addAttribute("companies", getCompanies());
            model.addAttribute("employees", getEmployeesForCompany(companyId));
            model.addAttribute(RESULT, getAvgSalaryForCompany(companyId));
            return LIST_URL;
        } catch (Exception exp) {
            model.addAttribute(RESULT, "");
            model.addAttribute("error", exp.getMessage());
            return LIST_URL;
        }
    }

    @RequestMapping(EDIT_URL)
    public String handleEditForm(@RequestParam(value = "id", defaultValue = "-1") Long id,
                                 @RequestParam(value = "companyId", defaultValue = "-1") Long companyId,
                                 EmployeeEntity entity,
                                 HttpServletResponse httpServletResponse) {
        if (entity != null &&
                entity.getName() != null &&
                !entity.getName().isEmpty() &&
                entity.getSurname() != null &&
                !entity.getSurname().isEmpty()) {
            updateEmployee(id, companyId, entity);
            httpServletResponse.setHeader("Location", "/employees");
        } else if (id >= 0) {
            EmployeeEntity fromDB = getEmployee(id, companyId);
            if (entity != null) {
                entity.setName(fromDB.getName());
                entity.setSurname(fromDB.getSurname());
                entity.setEmail(fromDB.getEmail());
                entity.setAddress(fromDB.getAddress());
                entity.setSalary(fromDB.getSalary());
                entity.setId(id);
                entity.setCompany(fromDB.getCompany());
            }
        } else {
            if (entity != null) {
                entity.setCompany(getCompany(companyId));
            }
        }
        return EDIT_URL;
    }

    @RequestMapping(DELETE_URL)
    public String handleDeleteForm(@RequestParam(value = "id", defaultValue = "-1") Long id,
                                   @RequestParam(value = "companyId", defaultValue = "-1") Long companyId,
                                   MainFormModel mainFormModel,
                                   Model model) {
        deleteEmployee(id, companyId);
        return DELETE_URL;
    }

    @RequestMapping(REGISTER_URL)
    public String handleRegisterForm(AdminEntity adminEntity, Model model) {
        try {
            if (adminEntity.getUserName() != null && !adminEntity.getUserName().isEmpty()) {
                if (adminRepository.findByUserName(adminEntity.getUserName()) != null) {
                    model.addAttribute("error", "This UserName already used");
                    model.addAttribute("countires", countryService.getCountriesNames());
                    return REGISTER_URL;
                } else {
                    adminRepository.save(adminEntity);
                    return LOGIN_URL;
                }
            } else {
                model.addAttribute("countires", countryService.getCountriesNames());
                return REGISTER_URL;
            }
        } catch (Exception exp) {
            model.addAttribute("error", exp.getMessage());
            return REGISTER_URL;
        }
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(LOGIN_URL);
        registry.addViewController("/" + LOGIN_URL).setViewName(LOGIN_URL);
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Model model, Exception ex) {
        errorRepository.save(new ErrorEntity("Error in MVC service", ex));
        model.addAttribute("error", ex.getMessage());
        return LIST_URL;
    }

}
