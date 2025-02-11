package com.mugiwara.HuffmanCoder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TimeResponse {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int nano;
}
