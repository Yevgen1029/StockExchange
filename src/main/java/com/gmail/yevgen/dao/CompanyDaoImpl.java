package com.gmail.yevgen.dao;

import com.gmail.yevgen.dao.interfaces.CompanyDao;
import com.gmail.yevgen.model.Company;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl extends AbstractDao<Company> implements CompanyDao {

    public Company read(Class<Company> tClass, String companyCode) {
        Session session = sessionFactory.getCurrentSession();
        Company company = (Company) session.get(tClass, companyCode);
        session.flush();
        return company;
    }

    public List<Company> getAllCompanies() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Company");
        List<Company> companies = query.list();
        session.flush();
        return companies;
    }
}
