package com.ppmt.ppmtFullstBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ppmt.ppmtFullstBoot.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	Iterable<Project> findAll();

	Project findByProjectIdentifier(String projectidentifier);
	

}
