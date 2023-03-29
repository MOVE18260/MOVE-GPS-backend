package dev.move.gps.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RecordResponse {

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private final LocalDateTime dateTime;

    private final String location;

    private final int step;

    private final int distance;
}
