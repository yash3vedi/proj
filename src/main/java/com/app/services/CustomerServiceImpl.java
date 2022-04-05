package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerRepository;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public String signUpCustomer(Customer cust) {
		Customer cust2 = customerRepo.save(cust);
		return "Customer Signup successfully with ID : " + cust2.getId();
	}
	

	@Override
	public Customer authenticateCustomer(String email, String password) {
	
		return customerRepo.findByCustomerEmailAndCustomerpassword(email, password)
				.orElseThrow(() -> new RuntimeException("Invalid Credentials!!!!!"));
	}

}
