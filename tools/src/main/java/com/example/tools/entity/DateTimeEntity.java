package com.example.tools.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class DateTimeEntity {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private LocalDateTime time;
}
