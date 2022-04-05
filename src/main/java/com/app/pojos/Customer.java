package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Entity
@Table(name = "customers")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Customer extends BaseEntity {
	public Customer() {}
	
	public Customer(String customerName, String customerCoapplicantName, String customerpassword, String customerEmail,
			String customerAddress, String customerMobile, String customerAdhar) {
		super();
		this.customerName = customerName;
		this.customerCoapplicantName = customerCoapplicantName;
		this.customerpassword = customerpassword;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerMobile = customerMobile;
		this.customerAdhar = customerAdhar;
	}
	
	@Column(name = "cust_name",length=20)
	@NotBlank(message = "Customer name is required")
	private String customerName;
	
	@Column(name = "cust_appli_name",length=20)
	@NotBlank(message = "Coapplicant name is required")
	private String customerCoapplicantName;
	
	@Column(name = "cust_password",length=20)
	@NotBlank(message = "Password is required")
	private String customerpassword;
	
	@Column(name = "cust_email",length=20, unique = true)
	@NotBlank(message = "Confirm Password is required")
	private String customerEmail;
	
	@Column(name = "cust_address",length=50)
	@NotBlank(message = "Address is required")
	private String customerAddress;
	
	@Column(name = "cust_mobile",length=10, unique = true)
	@NotBlank(message = "Mobile Number is required")
	@Pattern(regexp="^(\\d{10})", message = "length must be 10")
	private String customerMobile;
	
	@Column(name = "cust_adhar")
	@NotBlank(message = "Aadhar Number is required")
	@Pattern(regexp="^(\\d{12})", message = "length must be 12")
	private String customerAdhar;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	
	
}
