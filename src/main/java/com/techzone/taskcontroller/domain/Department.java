package com.techzone.taskcontroller.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String departmentName;

	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Person> persons = new ArrayList<>();

	@OneToMany(mappedBy = "department")
	private List<ProjectHistory> projectHistories = new ArrayList<>();

	public Department() {
		// EMPTY CONSTRUCTOR
	}

	public Department(Integer id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<ProjectHistory> getProjectHistories() {
		return projectHistories;
	}

	public void setProjectHistories(List<ProjectHistory> projectHistories) {
		this.projectHistories = projectHistories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
