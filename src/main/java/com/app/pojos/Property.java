package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Property extends BaseEntity {
	public Property() {}
	
	public Property(PropertyStatus propertyStatus, String propertyArea) {
		super();
		this.propertyStatus = propertyStatus;
		this.propertyArea = propertyArea;
	}
	@Column(name = "property_status",length=20)
	@Enumerated(EnumType.STRING)
	private PropertyStatus propertyStatus;
	@Column(name = "property_area",length=20)
	private String propertyArea;
	@ManyToOne
	@JoinColumn(name = "project_id",nullable = false)
	private Project projectId;
	@ManyToOne
	@JoinColumn(name = "customer_id",nullable = true)
	private Customer propertycustomer;
	
	
	public Project getProjectId() {
		return projectId;
	}
	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}
	public Customer getPropertycustomer() {
		return propertycustomer;
	}
	public void setPropertycustomer(Customer propertycustomer) {
		this.propertycustomer = propertycustomer;
	}

	public PropertyStatus getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(PropertyStatus propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	@Override
	public String toString() {
		return "Property [propertyStatus=" + propertyStatus + ", propertyArea=" + propertyArea + ", projectId="
				+ projectId.getId() + ", propertycustomer=" + propertycustomer.getId() + "]";
	}	
	
	
	
}
