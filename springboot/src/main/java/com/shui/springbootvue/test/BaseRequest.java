package com.shui.springbootvue.test;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description 接口请求基类
 * @Date 2019/5/23 11:16
 * @Author vnaLc
 */
public class BaseRequest implements Serializable {

    /**
     * 交易编码
     */
    private String order_no;
    /**
     * 交易日期
     */
    private String trans_date;
    /**
     * 交易时间
     */
    private String trans_time;

    @Override
    protected BaseRequest clone() {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setOrder_no(this.order_no);
        baseRequest.setTrans_date(this.trans_date);
        baseRequest.setTrans_time(this.trans_time);
        return baseRequest;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }

    public String getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(String trans_time) {
        this.trans_time = trans_time;
    }
}
