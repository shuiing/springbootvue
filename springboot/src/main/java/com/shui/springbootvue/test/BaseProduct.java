package com.shui.springbootvue.test;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @description: 无<br>
 * @version: 1.0 <br>
 * @date: 2019/5/29 14:34 <br>
 * @author: leejun <br>
 */
public class BaseProduct implements Serializable {
    private static final long serialVersionUID = -6322483061369423873L;

    private String name;

    private String code;

    private String mnemonic_code;

    private String category_name;
    private String category_name_2;

    private Long category_id;
    private Long category_id_2;
    private BigDecimal weight;

    private BigDecimal volume;

    private BigDecimal price;

    private BigDecimal pur_price;

    private BigDecimal cost_price;

    private BigDecimal dis_price;

    private Integer stock;

    private List<String> channel_key;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMnemonic_code() {
        return mnemonic_code;
    }

    public void setMnemonic_code(String mnemonic_code) {
        this.mnemonic_code = mnemonic_code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPur_price() {
        return pur_price;
    }

    public void setPur_price(BigDecimal pur_price) {
        this.pur_price = pur_price;
    }

    public BigDecimal getCost_price() {
        return cost_price;
    }

    public void setCost_price(BigDecimal cost_price) {
        this.cost_price = cost_price;
    }

    public BigDecimal getDis_price() {
        return dis_price;
    }

    public void setDis_price(BigDecimal dis_price) {
        this.dis_price = dis_price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<String> getChannel_key() {
        return channel_key;
    }

    public void setChannel_key(List<String> channel_key) {
        this.channel_key = channel_key;
    }

    public String getCategory_name_2() {
        return category_name_2;
    }

    public void setCategory_name_2(String category_name_2) {
        this.category_name_2 = category_name_2;
    }

    public Long getCategory_id_2() {
        return category_id_2;
    }

    public void setCategory_id_2(Long category_id_2) {
        this.category_id_2 = category_id_2;
    }
}
