package com.shui.springbootvue.test;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @Description
 * @Date 2019/5/23 9:56
 * @Author vnaLc
 */
public class BaseUser implements Serializable{

    private static final long serialVersionUID = -6758348009599863219L;

    private String user_code;

    private String login_name;

    private String username;

    private String icon;

    private Integer status = 0;

    private Integer sex = 0;

    private String mobile;

    private String email;

    private String birthday;

    private String salesman;

    private String phone;

    private String province;
    private String city;

    private String address;

    private String person_sign;

    private Integer is_member;

    private String user_source;

    private String remark;

    private String level_code;
    /**
     * 会员渠道信息
     */
    public List<String> channelKeyList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson_sign() {
        return person_sign;
    }

    public void setPerson_sign(String person_sign) {
        this.person_sign = person_sign;
    }

    public Integer getIs_member() {
        return is_member;
    }

    public void setIs_member(Integer is_member) {
        this.is_member = is_member;
    }

    public String getUser_source() {
        return user_source;
    }

    public void setUser_source(String user_source) {
        this.user_source = user_source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLevel_code() {
        return level_code;
    }

    public void setLevel_code(String level_code) {
        this.level_code = level_code;
    }

    public List<String> getChannelKeyList() {
        return channelKeyList;
    }

    public void setChannelKeyList(List<String> channelKeyList) {
        this.channelKeyList = channelKeyList;
    }
}
