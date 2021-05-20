package com.zvl.theraven_technical_task.controller;

import com.zvl.theraven_technical_task.model.Customer;
import com.zvl.theraven_technical_task.model.CustomerDTO;
import com.zvl.theraven_technical_task.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody @Valid Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<CustomerDTO> readAllCustomers() {
        return customerService.readAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO readCustomer(@PathVariable Long id) {
        return customerService.readCustomer(id);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody @Valid Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
