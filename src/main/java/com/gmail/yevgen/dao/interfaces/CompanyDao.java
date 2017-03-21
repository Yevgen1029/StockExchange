package com.gmail.yevgen.dao.interfaces;

import com.gmail.yevgen.model.Company;

import java.util.List;

public interface CompanyDao extends GenericDao<Company> {
    Company read(Class<Company> tClass, String companyCode);
    List<Company> getAllCompanies();
}
