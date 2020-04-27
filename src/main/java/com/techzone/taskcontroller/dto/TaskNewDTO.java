package com.techzone.taskcontroller.dto;

import java.util.Date;
import com.techzone.taskcontroller.domain.Task;
import com.techzone.taskcontroller.util.FormatDate;

public class TaskNewDTO {

    private Integer id;
    private String title;
    private String description;
    private Long taskPoints;
    private Long status;
    private Date startDate;
    private Date endDate;
    private Integer projectId;

    public TaskNewDTO(){
        this.projectId = 0;
    }

    public TaskNewDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.taskPoints = task.getTaskPoints();
        this.status = task.getStatus().getCod();
        this.startDate = task.getStartDate();
        this.endDate = task.getEndDate();
    }

    public TaskNewDTO(Integer id, String title, String description, Long taskPoints, Long status, String startDate,
    String endDate, Integer projectId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskPoints = taskPoints;
        this.status = status;
        this.startDate = FormatDate.parse(startDate, "dd/MM/yyyy");
        this.endDate = FormatDate.parse(endDate, "dd/MM/yyyy");
        this.projectId = projectId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTaskPoints() {
        return this.taskPoints;
    }

    public void setTaskPoints(Long taskPoints) {
        this.taskPoints = taskPoints;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setStatus(Long status) {
        this.status = status;
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

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

}