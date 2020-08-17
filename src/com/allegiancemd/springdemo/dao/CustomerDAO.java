package com.allegiancemd.springdemo.dao;

import com.allegiancemd.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);
}
