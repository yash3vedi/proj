package com.app.services;

import com.app.pojos.Customer;


public interface ICustomerService {
//add a method to admit a student
	String signUpCustomer(Customer cust);
	Customer authenticateCustomer(String email,String password);
}
