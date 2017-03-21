package com.gmail.yevgen.dao.interfaces;

import com.gmail.yevgen.model.UserCompany;

import java.util.List;

public interface UserCompanyDao extends GenericDao<UserCompany> {
    List<UserCompany> read(Class<UserCompany> tClass, String userEmail);

}
