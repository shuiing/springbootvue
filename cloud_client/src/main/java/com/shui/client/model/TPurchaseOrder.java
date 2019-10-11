package com.shui.client.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 *  材料采购订单表
 */
@Data
@Table(name = "t_purchase_order")
public class TPurchaseOrder implements Serializable {

    private String order_bh;

    private String agreement_bh;

    private Integer order_status;

}