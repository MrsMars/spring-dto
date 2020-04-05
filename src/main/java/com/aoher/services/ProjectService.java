package com.aoher.services;

import com.aoher.entity.Project;

import java.util.List;

public interface ProjectService {

    Project saveProject(Project project);
    List<Project> getProjects();
    Project getProjectById(int projectId);
    void deleteProjectById(int projectId);
    Project updateProject(Project project);
}