package com.example.tools;

import com.example.tools.dateTime.Moment;
import com.example.tools.entity.TimeRangeEntity;
import com.example.tools.enums.TimeUnitsEnum;


public class testDateTimeExamples {
    public static void main(String[] args){
        log("本日：" + Moment.getTimeRange(TimeUnitsEnum.TODAY.value()).toString());
        log("本周：" + Moment.getTimeRange(TimeUnitsEnum.THIS_WEEK.value()).toString());
        log("本月：" + Moment.getTimeRange(TimeUnitsEnum.THIS_MONTH.value()).toString());
        log("本季度：" + Moment.getTimeRange(TimeUnitsEnum.THIS_QUARTER.value()).toString());
        log("本年：" + Moment.getTimeRange(TimeUnitsEnum.THIS_YEAR.value()).toString());
        log("==============================================================================");
        TimeRangeEntity tr = Moment.getTimeRange(TimeUnitsEnum.THIS_WEEK.value());
        log(tr.getStartTime().toLocalDate().toString());
        log("两个时间段内的天数："+ Moment.getDateRangeDaysNum(tr.getStartTime().toLocalDate(),tr.getEndTime().toLocalDate()));
    }
    private static void log(Object str){
        System.out.println(str);
    }
}
