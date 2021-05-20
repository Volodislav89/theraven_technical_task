package com.zvl.theraven_technical_task.service;

import com.zvl.theraven_technical_task.model.Customer;
import com.zvl.theraven_technical_task.model.CustomerDTO;
import com.zvl.theraven_technical_task.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public CustomerDTO createCustomer(Customer customer) {
        customer.setCreated(System.currentTimeMillis());
        customer.setActive(true);
        Customer newCustomer = customerRepository.save(customer);
        return modelMapper.map(newCustomer, CustomerDTO.class);
    }

    public List<CustomerDTO> readAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    public CustomerDTO readCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No Customer with id: %d", id)));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No Customer with id: %d", id)));
        existingCustomer.setFullName(customer.getFullName());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setUpdated(System.currentTimeMillis());
        customerRepository.save(existingCustomer);
        return modelMapper.map(existingCustomer, CustomerDTO.class);
    }

    public void deleteCustomer(Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No Customer with id: %d", id)));
        existingCustomer.setActive(false);
        customerRepository.save(existingCustomer);
    }
}
