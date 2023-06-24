package com.tota.restFullVueJs.service;

import com.tota.restFullVueJs.DTO.CustomerDTO;
import com.tota.restFullVueJs.entity.Customer;
import com.tota.restFullVueJs.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceIMPL(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setMobile(customerDTO.getMobile());
        customerRepository.save(customer);
        return customer.getName();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers =  customerRepository.findAll();
        return customers;
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsById(customerDTO.getId())){
            Customer customer = customerRepository.findById(customerDTO.getId()).get();
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            customer.setMobile(customerDTO.getMobile());
            customerRepository.save(customer);
        } else{
            System.out.println("User not found!");
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }else{
            System.out.println("User nto found!");
        }
        return true;
    }


}
