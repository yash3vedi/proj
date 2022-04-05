package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerRepository;
import com.app.dao.ProjectRepository;
import com.app.dao.PropertyRepository;
import com.app.pojos.Customer;
import com.app.pojos.Project;
import com.app.pojos.Property;
import com.app.pojos.PropertyStatus;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService{
	@Autowired
	private PropertyRepository propertyRepo;
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public String addNewProperty(Property ppt, int projectId) {
			Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Invalid topic id!!!!!!!!!!"));
			//Customer cust = customerRepo.findById(propertycustomer).orElseThrow(() -> new RuntimeException("Invalid topic id!!!!!!!!!!"));
			ppt.setProjectId(project);
			//ppt.setPropertycustomer(cust);
			Property property2 = propertyRepo.save(ppt);
			return "Added new tutorial with id=" + property2.getId();		
		//throw new RuntimeException("Validation Failure!!!!!");
		
	}
	@Override
	public String assingnPropertyToCustomer(Property props,int propertytId,int projectId,int customerId) {
		
		 props = propertyRepo.findById(propertytId).orElseThrow(() -> new RuntimeException("Invalid property id!!!!!!!!!!"));
		Customer cust = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Invalid customer id!!!!!!!!!!"));
		props.setPropertycustomer(cust);
		props.setPropertyStatus(PropertyStatus.valueOf("SOLD"));
		Property Property2 = propertyRepo.save(props);
		return "Added new tutorial with id=" +  Property2.getId();	
		
	}
	
	@Override
	public String deleteProperty(int id) {
		Property props = propertyRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid property Id:" + id));
		propertyRepo.delete(props);
		return "Added new tutorial with id=" +  id;
	}
	
}
