package com.ppmt.ppmtFullstBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppmt.ppmtFullstBoot.domain.Project;
import com.ppmt.ppmtFullstBoot.exceptions.ProjectIdException;
import com.ppmt.ppmtFullstBoot.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {

		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID " + project.getProjectIdentifier() + " already exists");
		}

	}

	public Project findProjectByIdentifier(String projectidentifier) {

		Project project = projectRepository.findByProjectIdentifier(projectidentifier.toUpperCase());

		if (project == null) {
			throw new ProjectIdException("Project Id - " + projectidentifier + " does not exists.");
		}
		return projectRepository.findByProjectIdentifier(projectidentifier.toUpperCase());
	}

	public Iterable<Project> findAllProjects() {

		return projectRepository.findAll();
	}

	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

		if (project == null) {
			throw new ProjectIdException("This Project Id - " + projectId + " does not exists.");
		}

		projectRepository.delete(project);

	}
	
}
