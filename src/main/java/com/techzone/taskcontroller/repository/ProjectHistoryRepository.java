package com.techzone.taskcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.taskcontroller.domain.ProjectHistory;

public interface ProjectHistoryRepository extends JpaRepository<ProjectHistory, Integer>{

}
