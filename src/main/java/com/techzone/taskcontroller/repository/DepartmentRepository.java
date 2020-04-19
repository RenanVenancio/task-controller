package com.techzone.taskcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.taskcontroller.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
