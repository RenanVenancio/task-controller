package com.techzone.taskcontroller.dto;

import java.io.Serializable;
import java.util.Date;

import com.techzone.taskcontroller.domain.Project;
import com.techzone.taskcontroller.util.FormatDate;

public class ProjectDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
	private String projectTitle;
	private Integer manager;	
	private Long minSalary;	
	private Long maxSalary;
	private Date startDate;	
	private Date endDate;
    private Integer department;
    
    public ProjectDTO(){

    }

    public ProjectDTO(Project project){
        this.id = project.getId();
        this.projectTitle = project.getProjectTitle();
        this.manager = project.getManager().getId();	
        this.minSalary = project.getMinSalary();	
        this.maxSalary = project.getMaxSalary();
        this.startDate = project.getStartDate();	
        this.endDate = project.getEndDate();
        this.department = project.getDepartment().getId();
    }

    public ProjectDTO(Integer id, String projectTitle, Integer manager, Long minSalary, Long maxSalary, String startDate, String endDate, Integer department) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.manager = manager;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.startDate = FormatDate.parse(startDate, "dd/MM/yyyy");
        this.endDate = FormatDate.parse(endDate, "dd/MM/yyyy");
        this.department = department;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return this.projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Integer getManager() {
        return this.manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Long getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = FormatDate.parse(startDate, "dd/MM/yyyy");
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = FormatDate.parse(endDate, "dd/MM/yyyy");
    }

    public Integer getDepartment() {
        return this.department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

}