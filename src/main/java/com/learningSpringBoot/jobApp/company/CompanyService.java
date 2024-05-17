package com.learningSpringBoot.jobApp.company;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean updateCompany(Company company, Long id);

    boolean deleteCompany(Long id);
}
