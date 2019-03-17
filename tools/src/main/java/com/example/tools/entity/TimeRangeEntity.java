package com.example.tools.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 时间段
 */
public class TimeRangeEntity {
    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private LocalDateTime startTime;
    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private LocalDateTime endTime;

    public TimeRangeEntity(){
        this.startTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        this.endTime = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "{" +
                "startTime=" + startTime.toString() +
                ", endTime=" + endTime.toString() +
                '}';
    }
}
