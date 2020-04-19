package com.techzone.taskcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.taskcontroller.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
