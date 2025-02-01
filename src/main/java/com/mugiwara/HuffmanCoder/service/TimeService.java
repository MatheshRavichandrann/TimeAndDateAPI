package com.mugiwara.HuffmanCoder.service;

import com.mugiwara.HuffmanCoder.dto.TimeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@Builder
@RequiredArgsConstructor
public class TimeService {

    private static final ZoneId IST_ZONE = ZoneId.of("Asia/Kolkata");

    public TimeResponse getCurrentDateTime() {
        ZonedDateTime time = ZonedDateTime.now(IST_ZONE);
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
