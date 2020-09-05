package com.allegiancemd.springdemo.controller;

import com.allegiancemd.springdemo.service.CustomerService;
import com.allegiancemd.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject our customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer (@ModelAttribute("customer") Customer customer ){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId,Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer",customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        customerService.removeCustomer(customerId);
        return "redirect:/customer/list";
    }
}
