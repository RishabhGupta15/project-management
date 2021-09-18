package com.rish.projectmanager.dao;

import com.rish.projectmanager.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
