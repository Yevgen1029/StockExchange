package com.gmail.yevgen.service.interfaces;

import com.gmail.yevgen.model.Company;

import java.util.List;

public interface CompanyService {
    Company addCompany(Company company);

    Company updateCompany(Company company);

    Company getCompanyByCode(String companyCode);

    Company deleteCompany(Company company);

    List<Company> getCompanies();
}
