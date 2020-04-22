package com.techzone.taskcontroller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.taskcontroller.domain.Department;
import com.techzone.taskcontroller.domain.Person;
import com.techzone.taskcontroller.domain.Project;
import com.techzone.taskcontroller.dto.ProjectNewDTO;
import com.techzone.taskcontroller.repository.DepartmentRepository;
import com.techzone.taskcontroller.repository.PersonRepository;
import com.techzone.taskcontroller.repository.ProjectRepository;
import com.techzone.taskcontroller.repository.TaskRepository;
import com.techzone.taskcontroller.service.excepetion.ObjectNotFoundException;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository repository;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	PersonService personService;

	@Autowired
	TaskRepository taskRepository;

	public Project findById(Integer id) {
		Optional<Project> project = repository.findById(id);
		return project.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public List<Project> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Project save(Project project) {
		project.setId(null); // Limpando o id, caso venha no objeto
		project = repository.save(project);
		taskRepository.saveAll(project.getTasks());
		return project;
		
	}

	public Project update(Project project) {
		Project oldData = findById(project.getId());
		return repository.save(updateData(oldData, project));
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private Project updateData(Project oldData, Project updated) {	
		oldData.setId(updated.getId());
		oldData.setProjectTitle(updated.getProjectTitle());
		oldData.setManager(updated.getManager());		
		oldData.setMinSalary(updated.getMinSalary());		
		oldData.setMaxSalary(updated.getMaxSalary());	
		oldData.setStartDate(updated.getStartDate());
		oldData.setEndDate(updated.getEndDate());	
		oldData.setDepartment(updated.getDepartment());
		return oldData;
	}

	public Project fromDTO(ProjectNewDTO projectDTO) {

		Department department = departmentService.findById(projectDTO.getDepartment());

		Person person = personService.findById(projectDTO.getManager());

		Project project = new Project(
			null,
			projectDTO.getProjectTitle(),
			person,	
			projectDTO.getMinSalary(),		
			projectDTO.getMaxSalary(),	
			projectDTO.getStartDate(),
			projectDTO.getEndDate(),	
			department
		);

		project.getTasks().addAll(projectDTO.getTasks());
		
		return project;
	}
}
