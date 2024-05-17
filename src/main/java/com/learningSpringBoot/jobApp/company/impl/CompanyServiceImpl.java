package com.learningSpringBoot.jobApp.company.impl;

import com.learningSpringBoot.jobApp.company.Company;
import com.learningSpringBoot.jobApp.company.CompanyRepository;
import com.learningSpringBoot.jobApp.company.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        try{
            return companyRepository.findAll();
        }
        catch (Exception e){
            throw new RuntimeException("No companies found");
        }
    }

    @Override
    public void createCompany(Company company) {
        try {
            companyRepository.save(company);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            return companyOptional.get();
        }
        else{
            throw new RuntimeException("Company Not found");
        }
    }
}
