package com.tota.restFullVueJs.service;

import com.tota.restFullVueJs.DTO.CustomerDTO;
import com.tota.restFullVueJs.entity.Customer;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomerDTO customerDTO);

    List<Customer> getAllCustomers();

    String updateCustomer(CustomerDTO customerDTO);

    boolean deleteCustomer(int id);
}
