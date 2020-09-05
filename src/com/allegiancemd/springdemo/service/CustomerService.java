package com.allegiancemd.springdemo.service;

import com.allegiancemd.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);


    public Customer getCustomer(int customerId);

    public void removeCustomer(int customerId);

    public List<Customer> searchCustomer(String theCustomerName);
}
