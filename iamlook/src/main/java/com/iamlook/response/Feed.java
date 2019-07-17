package com.iamlook.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 19-7-17下午1:30
 */
@Data
public class Feed {

    private String id;

    /**
     * 关联Input
     */

    private String inputId;

    /**
     * 关联device
     */
    private String deviceId;

    /**
     *feed唯一识别号
     */
    private String feedNum;

    /**
     *feed在设备中的排序数
     */
    private int num;

    /**
     *feed名称
     */
    private String name;

    /**
     *feed单位code
     */
    private String unitId;

    /**
     *feed单位
     */
    private String unit;

    /**
     * 间隔值
     */
    private Double intervalValue;

    /**
     *间隔单位
     */
    private IntervalUnitType intervalUnitType;

    /**
     *上次数值
     */
    private BigDecimal lastValue;

    /**
     *更新时间
     */
    private String updateTime;

}