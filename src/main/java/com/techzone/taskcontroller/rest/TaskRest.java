package com.techzone.taskcontroller.rest;

import java.util.List;

import javax.validation.Valid;

import com.techzone.taskcontroller.domain.Project;
import com.techzone.taskcontroller.domain.Task;
import com.techzone.taskcontroller.dto.TaskNewDTO;
import com.techzone.taskcontroller.service.ProjectService;
import com.techzone.taskcontroller.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks/")
public class TaskRest {

    @Autowired
    TaskService service;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> filterByDate(@RequestParam String initialDate, @RequestParam String finalDate) {
        return ResponseEntity.ok().body(service.filterByDate(initialDate, finalDate));
    }

    @RequestMapping(value = "/date-and-status", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> filterByDateAndStatus(@RequestParam String initialDate,
            @RequestParam String finalDate, @RequestParam Long status) {
        return ResponseEntity.ok().body(service.filterByDateAndStatus(initialDate, finalDate, status));
    }

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> filterByDate(@RequestParam Long initialPoints, @RequestParam Long finalPoints) {
        return ResponseEntity.ok().body(service.filterByPoints(initialPoints, finalPoints));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Project> save(@Valid @RequestBody TaskNewDTO taskDTO) {
        Project task = service.fromDtoToProject(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(task));
    }

}