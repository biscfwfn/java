package com.example.tools;

import com.example.tools.dateTime.Moment;

public class testDateTimeExamples {
    public static void main(String[] args){
        log(Moment.getRange().toString());
    }
    private static void log(Object str){
        System.out.println(str);
    }
}
