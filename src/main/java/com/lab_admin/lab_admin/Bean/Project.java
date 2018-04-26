package com.lab_admin.lab_admin.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer project_id;
    private String project_name;
    private String project_imagepath;
    private String project_introduction;
    private String project_link;
    private String project_date;

    public Project() {
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_imagepath() {
        return project_imagepath;
    }

    public void setProject_imagepath(String project_imagepath) {
        this.project_imagepath = project_imagepath;
    }

    public String getProject_introduction() {
        return project_introduction;
    }

    public void setProject_introduction(String project_introduction) {
        this.project_introduction = project_introduction;
    }

    public String getProject_link() {
        return project_link;
    }

    public void setProject_link(String project_link) {
        this.project_link = project_link;
    }

    public String getProject_date() {
        return project_date;
    }

    public void setProject_date(String project_date) {
        this.project_date = project_date;
    }
}
