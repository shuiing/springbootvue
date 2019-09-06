package com.shui.springbootvue.test;



import java.io.Serializable;

/**
 * @description: 无<br>
 * @version: 1.0 <br>
 * @date: 2019/5/29 14:40 <br>
 * @author: leejun <br>
 */
public class BaseCategory implements Serializable {

    private static final long serialVersionUID = -4446203661459605208L;

    private Long id;

    private Long p_id;

    private String name;

    private Integer level;

    private String product_unit;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(String product_unit) {
        this.product_unit = product_unit;
    }
}
