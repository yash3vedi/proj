package com.app.services;

import com.app.pojos.Admin;

public interface IAdminService {
	String signUpAdmin(Admin adm);
	Admin authenticateAdmin(String email,String password);
}
