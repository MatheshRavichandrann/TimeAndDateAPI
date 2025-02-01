package com.mugiwara.HuffmanCoder.service;

import com.mugiwara.HuffmanCoder.dto.TimeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Builder
@RequiredArgsConstructor
public class TimeService {



    public TimeResponse getCurrentDateTime() {
        LocalDateTime time = LocalDateTime.now();
        return TimeResponse.builder()
                .year(time.getYear())
                .month(time.getMonthValue())
                .day(time.getDayOfMonth())
                .hour(time.getHour())
                .minute(time.getMinute())
                .second(time.getSecond())
                .nano(time.getNano())
                .build();
    }
}
