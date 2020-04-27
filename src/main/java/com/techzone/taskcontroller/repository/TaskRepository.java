package com.techzone.taskcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import com.techzone.taskcontroller.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

    public List<Task> findByStartDateBetweenAndStatus(Date initialDate, Date finalDate, Long status);
    public List<Task> findByStartDateBetween(Date initialDate, Date finalDate);
    public List<Task> findByTaskPointsBetween(Long initialPoints, Long finalPoints);

}
