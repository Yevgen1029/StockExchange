package com.gmail.yevgen.util;

import com.gmail.yevgen.model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Admin {
    private User admin = new User();
    private Properties prop= new Properties();

    public User getAdmin() {
        try {
            prop.load(new FileInputStream("F:\\1\\StockExchange\\src\\main\\resources\\admindata.properties"));
            admin.setPassword(prop.getProperty("password"));
            admin.setEmail(prop.getProperty("email"));
            admin.setFirstName(prop.getProperty("firstName"));
            admin.setLastName(prop.getProperty("lastName"));
            admin.setPhoneNumber(Long.parseLong(prop.getProperty("phoneNumber")));
            admin.setUsername(prop.getProperty("username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
