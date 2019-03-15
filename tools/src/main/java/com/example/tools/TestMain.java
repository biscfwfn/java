package com.example.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Predicate;

public class TestMain {
    public static void main(String[] args) {
        // lambda 表达式
        lambda test = (int a,int b) -> a + b;
        log(test.add(1,2));
        // 函数式接口
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream().filter(n -> true).forEach(TestMain::log);
        list.parallelStream().filter(n -> n%3 == 0).forEach(TestMain::log);
        //
        log("---------------------------------------------------------");
        log(LocalDateTime.now().getDayOfWeek().getValue());
        log(getWeekAndYear("2019-03-11"));
        log("---------------------------------------------------------");
        log("本日开始："+LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toString());
        log("本周开始："+LocalDateTime.of(LocalDate.now(), LocalTime.MIN).plusDays(0-LocalDateTime.now().getDayOfWeek().getValue()+1).toString());
        log("本月开始："+LocalDateTime.of(LocalDate.now(), LocalTime.MIN).plusDays(0-LocalDateTime.now().getDayOfMonth()+1).toString());
        log("本季开始："+LocalDateTime.of(LocalDate.now(), LocalTime.MIN).plusDays(0-LocalDateTime.now().getDayOfMonth()+1).toString());
        log("本年开始："+LocalDateTime.of(LocalDate.now(), LocalTime.MIN).plusDays(0-LocalDateTime.now().getDayOfYear()+1).toString());
    }
    interface lambda {
        abstract int add(int a,int b);
    }
    private static void evel(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n: list){
            if(predicate.test(n)){
                log(n);
            }
        }
    }
    private static void log(Object s){
        System.out.println(s);
    }
    public static String getWeekAndYear(String date) {
        Map<String,Integer> result =  new HashMap<String,Integer>();
        Calendar cal = Calendar.getInstance();

        // 设置一周的开始,默认是周日,这里设置成星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatMon = new SimpleDateFormat("MM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        Date d = null;
        try {
            d = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.setTime(d);
        int month = Integer.valueOf(formatMon.format(d));
        int year = Integer.valueOf(formatYear.format(d));

        int week = cal.get(Calendar.WEEK_OF_YEAR);
        if(week == 1 && month == 12){
            return year + 1 + "-" + week;
        }else{
            return year + "-" + week;
        }
    }
}
