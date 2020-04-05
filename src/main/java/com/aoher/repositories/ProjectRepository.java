package com.aoher.repositories;

import com.aoher.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Project findProjectByProjectId(int projectId);
}