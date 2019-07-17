package com.iamlook.response;

/**
 * 固件更新状态枚举
 */
public enum IntervalUnitType {

    SECOND("s","秒"), MINUTE("min","分"), HOUR("h","时"), DAY("d","天")  ;

    private String name;

    private String desc;

    IntervalUnitType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }
    public String getDesc(){
        return this.desc;
    }

}
