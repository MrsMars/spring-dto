package com.aoher.controller;

import com.aoher.dto.ProjectDto;
import com.aoher.dto.mapper.ProjectDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectDtoMapper projectDtoMapper;

    @PostMapping("/save")
    public HttpStatus saveProject(@Valid @RequestBody ProjectDto projectDto) {
        projectDtoMapper.saveProject(projectDto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/getAllProjects")
    public List<ProjectDto> getProjects(){
        return projectDtoMapper.getAllProjects();
    }

    @DeleteMapping("/deleteProjectById/{id}")
    public ResponseEntity<ProjectDto> deleteProject(@PathVariable int id){
        projectDtoMapper.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/updateProject")
    public ResponseEntity<ProjectDto> updateProject(@Valid @RequestBody ProjectDto projectDto){
        projectDtoMapper.updateProjects(projectDto);
        return new ResponseEntity<>(projectDto, HttpStatus.NO_CONTENT);
    }
}