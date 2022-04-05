package com.app.services;

import com.app.pojos.Property;

public interface IPropertyService {
	String addNewProperty(Property ppt, int projectId);
	String assingnPropertyToCustomer(Property props,int propertytId,int projectId,int customerId);
	String deleteProperty( int id);
}
