package com.gmail.yevgen.service;

import com.gmail.yevgen.dao.interfaces.CompanyDao;
import com.gmail.yevgen.model.Company;
import com.gmail.yevgen.service.interfaces.CompanyService;
import com.gmail.yevgen.util.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    JSONParser jsonParser;

    public Company addCompany(Company company) {
        companyDao.create(company);
        return company;
    }


    public Company updateCompany(Company company) {
        return companyDao.update(company);
    }


    public Company getCompanyByCode(String companyCode) {
        return companyDao.read(Company.class, companyCode);
    }


    public Company deleteCompany(Company company) {
        return company;
    }

    public List<Company> getCompanies() {
        return companyDao.getAllCompanies();
    }
}
