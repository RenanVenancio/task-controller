package com.techzone.taskcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.taskcontroller.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
