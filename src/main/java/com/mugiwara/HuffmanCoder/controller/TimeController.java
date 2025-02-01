package com.mugiwara.HuffmanCoder.controller;

import com.mugiwara.HuffmanCoder.dto.TimeResponse;
import com.mugiwara.HuffmanCoder.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/time")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @GetMapping("/current")
    public ResponseEntity<TimeResponse> getCurrentDateTime() {
        return ResponseEntity.ok(timeService.getCurrentDateTime());
    }
}
