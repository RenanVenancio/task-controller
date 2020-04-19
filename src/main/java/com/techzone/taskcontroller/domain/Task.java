package com.techzone.taskcontroller.domain;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String description;
	private Long taskPoints;
	private Long status;
	private Date startDate;
	private Date endDate;

	public Task() {
		// EMPTY CONSTRUCTOR
	}

	public Task(Integer id, String title, String description, Long taskPoints, Long status, Date startDate,
			Date endDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.taskPoints = taskPoints;
		this.status = status;
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

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
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

}
