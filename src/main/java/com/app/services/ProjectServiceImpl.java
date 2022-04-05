package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProjectRepository;
import com.app.pojos.Project;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService{
	@Autowired
	private ProjectRepository projectRepo;
	@Override
	public String addProject(Project pjt) {
		projectRepo.save(pjt);
		return "Project Added successfully";
	}

}
