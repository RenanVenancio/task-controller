package com.techzone.taskcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.taskcontroller.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
