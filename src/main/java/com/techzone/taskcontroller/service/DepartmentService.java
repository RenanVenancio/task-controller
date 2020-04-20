package com.techzone.taskcontroller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.taskcontroller.domain.Department;
import com.techzone.taskcontroller.repository.DepartmentRepository;
import com.techzone.taskcontroller.service.excepetion.ObjectNotFoundException;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	@Autowired
	DepartmentRepository departmentRepository;

	public Department findById(Integer id) {
		Optional<Department> department = repository.findById(id);
		return department.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public List<Department> findAll() {
		return repository.findAll();
	}

	public Department save(Department department) {
		department.setId(null); // Limpando o id, caso venha no objeto
		return repository.save(department);
	}

	public Department update(Department department) {
		Department oldData = findById(department.getId());
		return repository.save(updateData(oldData, department));
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private Department updateData(Department oldData, Department updated) {
		oldData.setId(updated.getId());
		oldData.setDepartmentName(updated.getDepartmentName());
		return oldData;
	}

}
