package dev.move.gps.service.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@Getter
public class GetRecordRequest {

    @DateTimeFormat(pattern = "yyyyMMddHHmm")
    private final LocalDateTime from;

    @DateTimeFormat(pattern = "yyyyMMddHHmm")
    private final LocalDateTime to;
}
