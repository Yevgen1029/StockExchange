package com.gmail.yevgen.service;

import com.gmail.yevgen.dao.interfaces.UserDao;
import com.gmail.yevgen.model.Companies;
import com.gmail.yevgen.model.Company;
import com.gmail.yevgen.model.User;
import com.gmail.yevgen.model.UserCompany;
import com.gmail.yevgen.service.interfaces.CompanyService;
import com.gmail.yevgen.service.interfaces.UserCompanyService;
import com.gmail.yevgen.service.interfaces.UserService;
import com.gmail.yevgen.util.Admin;
import com.gmail.yevgen.util.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCompanyService userCompanyService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    JSONParser<Companies> jsonParser;

    public User addUser(User user) {
        User addedUser = userDao.create(user);
        userDao.createStandardRole(user);
        return addedUser;
    }

    public User getUserByEmail(String userName) {
        return userDao.read(User.class, userName);
    }

    public User updateUser(User user) {
        return userDao.update(user);
    }

    public User deleteUser(User user) {
        return userDao.delete(user);
    }

    @Override
    public User createAdmin() {
        Properties prop = new Properties();
        String url = null;
        try {
            prop.load(new FileInputStream("src\\main\\resources\\admindata.properties"));
            url = prop.getProperty("JSON_URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        User admin = new Admin().getAdmin();
        userDao.createAdminRole(addUser(admin));
        Companies companies = jsonParser.getObject(Companies.class, url);
        List<Company> companyList = companies.getItems();
        for (Company company: companyList) {
            UserCompany userCompany = new UserCompany();
            userCompany.setUser(admin);
            userCompany.setCompany(companyService.addCompany(company));
            userCompanyService.addUserCompany(userCompany);
        }
        return admin;
    }
}