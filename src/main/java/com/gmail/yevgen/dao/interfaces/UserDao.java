package com.gmail.yevgen.dao.interfaces;


import com.gmail.yevgen.model.User;
import com.gmail.yevgen.model.UserRoles;

public interface UserDao extends GenericDao<User> {
    User read(Class<User> tClass, String username);
    UserRoles createStandardRole(User user);
    UserRoles createAdminRole(User user);

}
