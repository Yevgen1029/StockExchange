package com.gmail.yevgen.service.interfaces;

import com.gmail.yevgen.model.User;

public interface UserService {
    User addUser(User user);

    User getUserByEmail(String userName);

    User updateUser(User user);

    User deleteUser(User user);

    User createAdmin();
}
