package com.lab_admin.lab_admin.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sliderimage {
    @Id
    @GeneratedValue
    private Integer sliderimage_id;
    private String sliderimage_imagepath;
    private String sliderimage_info;
    private String sliderimage_link;
    private String sliderimage_date;

    public Sliderimage() {
    }

    public Integer getSliderimage_id() {
        return sliderimage_id;
    }

    public void setSliderimage_id(Integer sliderimage_id) {
        this.sliderimage_id = sliderimage_id;
    }

    public String getSliderimage_imagepath() {
        return sliderimage_imagepath;
    }

    public void setSliderimage_imagepath(String sliderimage_imagepath) {
        this.sliderimage_imagepath = sliderimage_imagepath;
    }

    public String getSliderimage_info() {
        return sliderimage_info;
    }

    public void setSliderimage_info(String sliderimage_info) {
        this.sliderimage_info = sliderimage_info;
    }

    public String getSliderimage_link() {
        return sliderimage_link;
    }

    public void setSliderimage_link(String sliderimage_link) {
        this.sliderimage_link = sliderimage_link;
    }

    public String getSliderimage_date() {
        return sliderimage_date;
    }

    public void setSliderimage_date(String sliderimage_date) {
        this.sliderimage_date = sliderimage_date;
    }
}
