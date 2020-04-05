package com.aoher.dto.mapper;

import com.aoher.dto.ProjectDto;
import com.aoher.entity.Project;
import com.aoher.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProjectDtoMapper {

    @Autowired
    private ProjectService projectService;

    ModelMapper modelMapper = new ModelMapper();

    PropertyMap<ProjectDto, Project> projectMap = new PropertyMap<>() {
        protected void configure() {
            map().setProjectName(source.getProjectName());
            map().setProjectDescription(source.getProjectDescription());
        }
    };

    @SuppressWarnings("unused")
    private ProjectDtoMapper entityToDTO(Project project) {
        return modelMapper.map(project, ProjectDtoMapper.class);
    }

    public Project saveProject(ProjectDto projectDto) {
        TypeMap<ProjectDto, Project> typeMap = modelMapper.getTypeMap(ProjectDto.class, Project.class);
        if (typeMap == null) {
            modelMapper.addMappings(projectMap);
        }

        Project project = modelMapper.map(projectDto, Project.class);
        return projectService.saveProject(project);
    }

    public List<ProjectDto> getAllProjects() {
        List<Project> project = projectService.getProjects();
        Type listType = new TypeToken<List<ProjectDto>>() {}.getType();
        return modelMapper.map(project, listType);
    }

    public ProjectDto deleteProject(int projectId) {
        projectService.deleteProjectById(projectId);
        return null;
    }

    public void updateProjects(ProjectDto projectDto) {
        Project project = modelMapper.map(projectDto, Project.class);
        entityToDTO(projectService.updateProject(project));
    }
}
