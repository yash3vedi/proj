package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "project")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Project extends BaseEntity {
	public Project() {
		
	}
	
	public Project(String projectLocation, String projectName, String projectPinCode, ProjectType projectType,
			ProjectStatus projectStatus) {
		super();
		this.projectLocation = projectLocation;
		this.projectName = projectName;
		this.projectPinCode = projectPinCode;
		this.projectType = projectType;
		this.projectStatus = projectStatus;
	}
	@Column(name = "project_location",length=20)
	private String projectLocation;
	@Column(name = "project_name",length=20)
	private String projectName;
	@Column(name = "project_pincode",length=6)
	private String projectPinCode;
	@Column(name = "project_type",length=20)
	@Enumerated(EnumType.STRING)
	private ProjectType projectType;
	@Column(name = "project_status",length=30)
	@Enumerated(EnumType.STRING)
	private ProjectStatus projectStatus;
	//(EnumType.STRING)

}
