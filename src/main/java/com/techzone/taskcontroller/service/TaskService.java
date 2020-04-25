package com.techzone.taskcontroller.service;

import java.util.List;
import java.util.Optional;

import com.techzone.taskcontroller.domain.Task;
import com.techzone.taskcontroller.repository.TaskRepository;
import com.techzone.taskcontroller.service.excepetion.ObjectNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    TaskRepository repository;

    public Task findById(Integer id){
        Optional<Task> task = repository.findById(id);
        return task.orElseThrow(() -> new ObjectNotFoundException("Task not found"));
    }

    public Task save(Task object){
        return repository.save(object);
    }

    public List<Task> findAll() {
		return repository.findAll();
	}

}