package com.allegiancemd.springdemo.controller;

import com.allegiancemd.springdemo.dao.CustomerDAO;
import com.allegiancemd.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;
    @GetMapping("/list")
    public String customersList(Model model) {
        List <Customer> customerList = customerDAO.getCustomers();
        model.addAttribute("customers",customerList);
        return "list-customers";
    }
}
