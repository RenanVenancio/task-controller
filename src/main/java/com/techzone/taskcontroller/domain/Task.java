package com.techzone.taskcontroller.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzone.taskcontroller.domain.enums.TaskStatus;

@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private Long taskPoints;
	private Long status;
	private Date startDate;
	private Date endDate;

	@JsonIgnore
	@ManyToMany(mappedBy = "tasks")
	private List<Project> projects = new ArrayList<>();

	public Task() {
		// EMPTY CONSTRUCTOR
	}

	public Task(Integer id, String title, String description, Long taskPoints, TaskStatus status, Date startDate,
			Date endDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.taskPoints = taskPoints;
		this.status = status.getCod();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTaskPoints() {
		return taskPoints;
	}

	public void setTaskPoints(Long taskPoints) {
		this.taskPoints = taskPoints;
	}

	public TaskStatus getStatus() {
		return TaskStatus.toEnum(status);
	}

	public void setStatus(TaskStatus status) {
		this.status = status.getCod();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
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
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", description='" + getDescription()
				+ "'" + ", taskPoints='" + getTaskPoints() + "'" + ", status='" + getStatus() + "'" + ", startDate='"
				+ getStartDate() + "'" + ", endDate='" + getEndDate() + "'" + ", projects='" + getProjects() + "'"
				+ "}";
	}

}
