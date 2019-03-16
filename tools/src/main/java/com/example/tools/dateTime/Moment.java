package com.example.tools.dateTime;

import com.example.tools.entity.DateUnitsNumEntity;
import com.example.tools.entity.TimeRangeEntity;
import com.example.tools.enums.TimeUnitsEnum;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 日期时间处理
 */
public class Moment {
    /**
     * 获取本日，本周，本月，本季度，本年时间段范围
     * @param unit 时间单位
     * @return { 开始时间，结束时间 }
     */
    public static TimeRangeEntity getTimeUnitsRange(String unit){
        TimeRangeEntity t = new TimeRangeEntity();
        t.setEndTime(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
        if(TimeUnitsEnum.TODAY.value().equals(unit)){
            t.setStartTime(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
        }else if(TimeUnitsEnum.THIS_WEEK.value().equals(unit)){
            t.setStartTime(LocalDateTime.of(LocalDate.now().plusDays(-LocalDate.now().getDayOfWeek().getValue()+1), LocalTime.MIN));
        }else if(TimeUnitsEnum.THIS_MONTH.value().equals(unit)){
            t.setStartTime(LocalDateTime.of(LocalDate.now().plusDays(-LocalDate.now().getDayOfMonth()+1), LocalTime.MIN));
        }else if(TimeUnitsEnum.THIS_QUARTER.value().equals(unit)){
            int m = LocalDate.now().getMonthValue();
            if(m % 3 == 0){
                m = -2;
            }else if((++m) % 3 == 0){
                m = -1;
            }else{
                m=0;
            }
            t.setStartTime(LocalDateTime.of(LocalDate.now().plusDays(-LocalDate.now().getDayOfMonth()+1).plusMonths(m), LocalTime.MIN));
        }else if(TimeUnitsEnum.THIS_YEAR.value().equals(unit)){
            t.setStartTime(LocalDateTime.of(LocalDate.now().plusDays(-LocalDate.now().getDayOfYear()+1), LocalTime.MIN));
        }else{
            t.setStartTime(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
        }
        return t;
    }

    /**
     * 计算两个日期之间的天数
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 天数
     */
    public static int getDateRangeDaysNum(LocalDate startDate,LocalDate endDate){
        return Math.toIntExact(endDate.toEpochDay() - startDate.toEpochDay() + 1);
    }

    /**
     * 计算两个日期之间的周数
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return  周数，第一周开始时间，结束时间
     */
    public static DateUnitsNumEntity getDateRangeWeekNum(LocalDate startDate,LocalDate endDate){
        DateUnitsNumEntity t = new DateUnitsNumEntity();
        t.setDateNum(0);
        t.setEndTime(LocalDateTime.of(endDate,LocalTime.MAX));
        for(int i=0;startDate.plusDays(i).isBefore(endDate) || startDate.plusDays(i).isEqual(endDate);i++){
            if(startDate.plusDays(i).getDayOfWeek().equals(DayOfWeek.MONDAY)){
                if(t.getDateNum() == 0){
                    t.setStartTime(LocalDateTime.of(startDate.plusDays(i),LocalTime.MIN));
                }
                t.setDateNum(t.getDateNum()+1);
            }
        }
        return t;
    }

    /**
     * 计算两个日期之间的月数
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static DateUnitsNumEntity getDateRangeMonthNum(LocalDate startDate,LocalDate endDate){
        DateUnitsNumEntity t = new DateUnitsNumEntity();
        t.setDateNum(0);
        t.setEndTime(LocalDateTime.of(endDate,LocalTime.MAX));
        for(int i=0;startDate.plusDays(i).isBefore(endDate) || startDate.plusDays(i).isEqual(endDate);i++){
            if(startDate.plusDays(i).getDayOfMonth() == 1){
                if(t.getDateNum() == 0){
                    t.setStartTime(LocalDateTime.of(startDate.plusDays(i),LocalTime.MIN));
                }
                t.setDateNum(t.getDateNum()+1);
            }
        }
        return t;
    }

    /**
     * 计算两个日期之间的季度数
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static DateUnitsNumEntity getDateRangeQuarterNum(LocalDate startDate,LocalDate endDate){
        DateUnitsNumEntity t = new DateUnitsNumEntity();
        t.setDateNum(0);
        t.setEndTime(LocalDateTime.of(endDate,LocalTime.MAX));
        for(int i=0;startDate.plusDays(i).isBefore(endDate) || startDate.plusDays(i).isEqual(endDate);i++){
            if(startDate.plusDays(i).getDayOfMonth() == 1 && (startDate.plusDays(i).getMonthValue()-1)%3 ==0){
                if(t.getDateNum() == 0){
                    t.setStartTime(LocalDateTime.of(startDate.plusDays(i),LocalTime.MIN));
                }
                t.setDateNum(t.getDateNum()+1);
            }
        }
        return t;
    }

    /**
     * 计算两个日期之间的年数
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static DateUnitsNumEntity getDateRangeYearNum(LocalDate startDate,LocalDate endDate){
        DateUnitsNumEntity t = new DateUnitsNumEntity();
        t.setDateNum(0);
        t.setEndTime(LocalDateTime.of(endDate,LocalTime.MAX));
        for(int i=0;startDate.plusDays(i).isBefore(endDate) || startDate.plusDays(i).isEqual(endDate);i++){
            if(startDate.plusDays(i).getDayOfYear() == 1){
                if(t.getDateNum() == 0){
                    t.setStartTime(LocalDateTime.of(startDate.plusDays(i),LocalTime.MIN));
                }
                t.setDateNum(t.getDateNum()+1);
            }
        }
        return t;
    }
}
