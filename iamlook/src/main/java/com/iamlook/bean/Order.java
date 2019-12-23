package com.iamlook.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 19-12-2下午5:16
 */
@Data
public class Order implements Serializable {

    private long userId;
    private long orderId;
    private long subOrderId;
    private long siteId;
    private String siteName;
    private long cityId;
    private String cityName;
    private long warehouseId;
    private long merchandiseId;
    private long quantity;
    private long orderStatus;
    private long isNewOrder;
    private Double price;
    private long timestamp;

}