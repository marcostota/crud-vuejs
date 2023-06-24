package com.tota.restFullVueJs.customerController;

import com.tota.restFullVueJs.DTO.CustomerDTO;
import com.tota.restFullVueJs.entity.Customer;
import com.tota.restFullVueJs.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        String name = customerService.addCustomer(customerDTO);
        return name;
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomer(){
        List<Customer> customers = customerService.getAllCustomers();
        return customers;
    }

    @PatchMapping("/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        String name= customerService.updateCustomer(customerDTO);
        return name;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        boolean deleteCustomer = customerService.deleteCustomer(id);
        return "Deleted";
    }

}
