package com.gmail.yevgen.controller;

import com.gmail.yevgen.model.Company;
import com.gmail.yevgen.model.User;
import com.gmail.yevgen.model.UserCompany;
import com.gmail.yevgen.service.interfaces.CompanyService;
import com.gmail.yevgen.service.interfaces.RandomWalletValue;
import com.gmail.yevgen.service.interfaces.UserCompanyService;
import com.gmail.yevgen.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserCompanyService userCompanyService;

    @Autowired
    RandomWalletValue randomWalletValue;

    @Autowired
    CompanyService companyService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String msg, Model model) {

        if (error != null) {
            error = "Wrong login or password";
            model.addAttribute("error", error);
        }

        if (msg != null) {
            msg = "You have been logged out successfully! Good Luck!";
            model.addAttribute("logout", msg);
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/user/userpage", method = RequestMethod.GET)
    public String getUserPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(auth.getName());
        List<UserCompany> userCompanies = userCompanyService.getUserCompaniesByUserEmail(user.getEmail());
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("stockCompanies", companies);
        model.addAttribute("companies", userCompanies);
        model.addAttribute("user", user);
        return "userPage";
    }

    @RequestMapping(value = "/user/properties", method = RequestMethod.GET)
    public String getUserPropertiesPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(auth.getName());
        model.addAttribute("companies", userCompanyService.getUserCompaniesByUserEmail(user.getEmail()));
        return "userProperties";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result,
                          ModelMap model) {
        if (userService.getUserByEmail("email") == null) {
            userService.createAdmin();
        }

        if (result.hasErrors()) return "register";
        user.setWallet(randomWalletValue.getRandomValue());

        model.addAttribute("user", new User());
        if (userService.getUserByEmail(user.getEmail()) != null) {                                                      //check for uniqueness of inputted email
            model.addAttribute("emailError", "This Email is already used! Please input another.");
            return "register";
        }
        model.addAttribute("addedUser", userService.addUser(user));
        return "login";
    }
}

