package com.gmail.yevgen.dao;

import com.gmail.yevgen.dao.interfaces.UserCompanyDao;
import com.gmail.yevgen.model.User;
import com.gmail.yevgen.model.UserCompany;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserCompanyDaoImpl extends AbstractDao<UserCompany> implements UserCompanyDao {


    public List<UserCompany> read(Class<UserCompany> tClass, String userEmail) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserCompany as c where c.user.email=:useremail")
                      .setParameter("useremail", userEmail);
        List<UserCompany> userCompanies = query.list();
        return userCompanies;
    }
}
