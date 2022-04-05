package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "admin")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Admin extends BaseEntity{
	public Admin() {}
	
	
	public Admin(String adminName, String adminEmail, String adminPassword, String adminMobile) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminMobile = adminMobile;
	}
	@Column(name = "admin_name",length=20)
	@NotBlank(message = "Admin name is required")
	private String adminName;
	@Column(name = "admin_email",length=30, unique = true)
	@NotBlank(message = "Admin email is required")
	private String adminEmail;
	@Column(name = "admin_password",length=10)
	@NotBlank(message = "Admin password name is required")
	private String adminPassword;
	@Column(name = "admin_mobile",length=10, unique = true)
	@NotBlank(message = "Admin mobile number is required")
	@Pattern(regexp="^(\\d{10})", message = "length must be 10")
	private String adminMobile;
	
	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
	
	

}
