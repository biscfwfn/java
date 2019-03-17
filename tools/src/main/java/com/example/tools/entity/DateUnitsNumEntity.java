package com.example.tools.entity;

/**
 * 两个时间段之间多少个时间单位
 */
public class DateUnitsNumEntity extends TimeRangeEntity{
    private Integer DateNum;

    public DateUnitsNumEntity(){
        this.DateNum = 0;
    }
    public Integer getDateNum() {
        return DateNum;
    }

    public void setDateNum(Integer dateNum) {
        DateNum = dateNum;
    }

    @Override
    public String toString() {
        return "{" +
                "startTime=" + super.getStartTime().toString() +
                ", endTime=" + super.getEndTime().toString() +
                ", DateNum=" + DateNum +
                '}';
    }
}
