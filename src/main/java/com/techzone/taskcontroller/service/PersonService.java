package com.techzone.taskcontroller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.taskcontroller.domain.Department;
import com.techzone.taskcontroller.domain.Person;
import com.techzone.taskcontroller.dto.PersonNewDTO;
import com.techzone.taskcontroller.repository.PersonRepository;
import com.techzone.taskcontroller.service.excepetion.ObjectNotFoundException;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	@Autowired
	DepartmentService departmentService;

	public Person findById(Integer id) {
		Optional<Person> person = repository.findById(id);
		return person.orElseThrow(() -> new ObjectNotFoundException("Person not found"));
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person save(Person person) {
		person.setId(null); // Limpando o id, caso venha no objeto
		return repository.save(person);
	}

	public Person update(Person person) {
		Person oldData = findById(person.getId());
		return repository.save(updateData(oldData, person));
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private Person updateData(Person oldData, Person updated) {
		oldData.setId(updated.getId());
		oldData.setFirstName(updated.getFirstName());
		oldData.setLastName(updated.getLastName());
		oldData.setEmail(updated.getEmail());
		oldData.setPhoneNumber(updated.getPhoneNumber());
		oldData.setHireDate(updated.getHireDate());
		return oldData;
	}

	public Person fromDTO(PersonNewDTO personDTO) {

		Department department = departmentService.findById(personDTO.getDepartment());

		return new Person(null, personDTO.getFirstName(), personDTO.getLastName(), personDTO.getEmail(),
				personDTO.getPhoneNumber(), personDTO.getHireDate(), department);
	}
}
