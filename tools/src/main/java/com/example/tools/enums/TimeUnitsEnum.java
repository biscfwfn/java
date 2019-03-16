package com.example.tools.enums;

public enum TimeUnitsEnum {
    TODAY("DAY","本日"),
    THIS_WEEK("WEEK","本周"),
    THIS_MONTH("MONTH","本月"),
    THIS_QUARTER("QUARTER","本季度"),
    THIS_YEAR("YEAR","本年");
    /**
     * 时间单位
     */
    private String units;
    private String note;
    TimeUnitsEnum(String units,String note){
        this.units = units;
        this.note = note;
    }
    public String value() {
        return units;
    }
    public String note(){
        return note;
    }

    @Override
    public String toString() {
        return "{" +
                "units='" + units + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
