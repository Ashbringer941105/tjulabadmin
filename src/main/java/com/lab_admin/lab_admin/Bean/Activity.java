package com.lab_admin.lab_admin.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Integer activity_id;
    private String activity_name;
    private String activity_introduction;
    private String activity_imagepath;
    private String activity_date;

    public Activity() {
    }

    public Integer getActivit_id() {
        return activity_id;
    }

    public void setActivit_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_introduction() {
        return activity_introduction;
    }

    public void setActivity_introduction(String activity_introduction) {
        this.activity_introduction = activity_introduction;
    }

    public String getActivity_imagepath() {
        return activity_imagepath;
    }

    public void setActivity_imagepath(String activity_imagepath) {
        this.activity_imagepath = activity_imagepath;
    }

    public String getActivity_date() {
        return activity_date;
    }

    public void setActivity_date(String activity_date) {
        this.activity_date = activity_date;
    }
}
