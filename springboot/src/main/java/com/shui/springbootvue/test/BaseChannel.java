package com.shui.springbootvue.test;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version 1.0
 * @Description
 * @Date 2019/5/23 9:57
 * @Author vnaLc
 */
public class BaseChannel implements Serializable {

    private String keys;

    private String name;

    private BigDecimal val = new BigDecimal("0");

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getVal() {
        return val;
    }

    public void setVal(BigDecimal val) {
        this.val = val;
    }
}
