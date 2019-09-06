package com.shui.springbootvue.test;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description
 * @Date 2019/5/23 9:57
 * @Author vnaLc
 */
public class BaseLevel implements Serializable {

    private String code;

    private String name;

    private Integer default_status = 0;

    private String note;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefault_status() {
        return default_status;
    }

    public void setDefault_status(Integer default_status) {
        this.default_status = default_status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
