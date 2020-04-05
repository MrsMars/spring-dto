package com.aoher.services.impl;

import com.aoher.entity.Project;
import com.aoher.repositories.ProjectRepository;
import com.aoher.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(int projectId) {
        return projectRepository.findProjectByProjectId(projectId);
    }

    @Override
    public void deleteProjectById(int projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }
}