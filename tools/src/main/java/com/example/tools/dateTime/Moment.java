package com.example.tools.dateTime;

import com.example.tools.entity.DateTimeRangeEntity;

/**
 * 日期时间处理
 */
public class Moment {
    /**
     * 获取本日，本周，本月，本季度，本年时间段范围
     * @param type 类型
     * @return 开始时间，结束时间
     */
    public static DateTimeRangeEntity getRange(String type){
        DateTimeRangeEntity t = new DateTimeRangeEntity();
        return t;
    }
}
