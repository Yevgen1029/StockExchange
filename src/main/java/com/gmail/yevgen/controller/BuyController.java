package com.gmail.yevgen.controller;

import com.gmail.yevgen.model.Company;
import com.gmail.yevgen.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BuyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping("/buy")
    public String makePurchase(Model model) {
        return "userPage";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Company> update() {
        return companyService.getCompanies();
    }
}
