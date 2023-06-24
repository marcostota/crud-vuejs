package com.tota.restFullVueJs.repository;

import com.tota.restFullVueJs.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, Integer> {
}
