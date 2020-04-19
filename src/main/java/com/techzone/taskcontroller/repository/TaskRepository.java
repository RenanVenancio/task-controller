package com.techzone.taskcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.taskcontroller.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
