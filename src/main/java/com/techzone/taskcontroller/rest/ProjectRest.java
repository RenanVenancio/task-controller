package com.techzone.taskcontroller.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.techzone.taskcontroller.domain.Project;
import com.techzone.taskcontroller.dto.ProjectDTO;
import com.techzone.taskcontroller.dto.ProjectNewDTO;
import com.techzone.taskcontroller.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects/")
public class ProjectRest {

    @Autowired
    ProjectService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project findById(Integer id){
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProjectDTO>> findAll(){
		List<Project> projectList = service.findAll();
		List<ProjectDTO> projectDTOs = projectList.stream().map((obj) -> new ProjectDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(projectDTOs);
    }
    
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Project> save(@Valid @RequestBody ProjectNewDTO projectDTO){
		Project project = service.fromDTO(projectDTO);
		return ResponseEntity.ok().body(service.save(project));
	}

}