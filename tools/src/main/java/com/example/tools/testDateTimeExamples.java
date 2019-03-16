package com.example.tools;

import com.example.tools.dateTime.Moment;
import com.example.tools.entity.TimeRangeEntity;
import com.example.tools.enums.TimeUnitsEnum;

import java.time.LocalDateTime;


public class testDateTimeExamples {
    public static void main(String[] args){
        log("本日：" + Moment.getTimeUnitsRange(TimeUnitsEnum.TODAY.value()).toString());
        log("本周：" + Moment.getTimeUnitsRange(TimeUnitsEnum.THIS_WEEK.value()).toString());
        log("本月：" + Moment.getTimeUnitsRange(TimeUnitsEnum.THIS_MONTH.value()).toString());
        log("本季度：" + Moment.getTimeUnitsRange(TimeUnitsEnum.THIS_QUARTER.value()).toString());
        log("本年：" + Moment.getTimeUnitsRange(TimeUnitsEnum.THIS_YEAR.value()).toString());
        log("==============================================================================");
        TimeRangeEntity tr = Moment.getTimeUnitsRange(TimeUnitsEnum.THIS_WEEK.value());
        log(tr.getStartTime().toLocalDate().toString());
        log("两个时间段内的天数："+ Moment.getDateRangeDaysNum(tr.getStartTime().toLocalDate(),tr.getEndTime().toLocalDate()));
        log("两个时间之间的周数："+Moment.getDateRangeWeekNum(LocalDateTime.now().plusDays(-15).toLocalDate(),tr.getStartTime().toLocalDate()).toString());
        log("两个时间之间的月数："+Moment.getDateRangeMonthNum(LocalDateTime.now().plusDays(-55).toLocalDate(),LocalDateTime.now().toLocalDate()).toString());
        log("两个时间之间的季度数："+Moment.getDateRangeQuarterNum(LocalDateTime.now().plusDays(-400).toLocalDate(),LocalDateTime.now().toLocalDate()).toString());
        log("两个时间之间的年数："+Moment.getDateRangeYearNum(LocalDateTime.now().plusDays(-500).toLocalDate(),LocalDateTime.now().toLocalDate()).toString());
    }
    private static void log(Object str){
        System.out.println(str);
    }
}
