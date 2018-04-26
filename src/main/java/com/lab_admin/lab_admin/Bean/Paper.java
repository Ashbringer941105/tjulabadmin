package com.lab_admin.lab_admin.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paper {
    @Id
    @GeneratedValue
    private Integer paper_id;
    private String paper_name;
    private String paper_author;
    private String paper_imagepath;
    private String paper_introduction;
    private String paper_link;
    private String paper_date;

    public Paper() {
    }

    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public String getPaper_name() {
        return paper_name;
    }

    public void setPaper_name(String paper_name) {
        this.paper_name = paper_name;
    }

    public String getPaper_author() {
        return paper_author;
    }

    public void setPaper_author(String paper_author) {
        this.paper_author = paper_author;
    }

    public String getPaper_imagepath() {
        return paper_imagepath;
    }

    public void setPaper_imagepath(String paper_imagepath) {
        this.paper_imagepath = paper_imagepath;
    }

    public String getPaper_introduction() {
        return paper_introduction;
    }

    public void setPaper_introduction(String paper_introduction) {
        this.paper_introduction = paper_introduction;
    }

    public String getPaper_link() {
        return paper_link;
    }

    public void setPaper_link(String paper_link) {
        this.paper_link = paper_link;
    }

    public String getPaper_date() {
        return paper_date;
    }

    public void setPaper_date(String paper_date) {
        this.paper_date = paper_date;
    }
}
