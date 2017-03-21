package com.gmail.yevgen.service.interfaces;

import com.gmail.yevgen.model.UserCompany;

import java.util.List;

public interface UserCompanyService {
    UserCompany addUserCompany(UserCompany userCompany);

    List<UserCompany> getUserCompaniesByUserEmail(String email);

    UserCompany updateUserCompany(UserCompany userCompany);

    UserCompany deleteUserCompany(UserCompany userCompany);
}
