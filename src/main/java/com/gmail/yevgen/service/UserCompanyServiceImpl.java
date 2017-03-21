package com.gmail.yevgen.service;

import com.gmail.yevgen.dao.interfaces.UserCompanyDao;
import com.gmail.yevgen.model.User;
import com.gmail.yevgen.model.UserCompany;
import com.gmail.yevgen.service.interfaces.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCompanyServiceImpl implements UserCompanyService {
    @Autowired
    UserCompanyDao userCompanyDao;

    public UserCompany addUserCompany(UserCompany userCompany) {
        return userCompanyDao.create(userCompany);
    }

    public List<UserCompany> getUserCompaniesByUserEmail(String email) {
        return userCompanyDao.read(UserCompany.class, email);
    }

    public UserCompany updateUserCompany(UserCompany userCompany) {
        return userCompanyDao.update(userCompany);
    }

    public UserCompany deleteUserCompany(UserCompany userCompany) {
        return userCompanyDao.delete(userCompany);
    }
}
