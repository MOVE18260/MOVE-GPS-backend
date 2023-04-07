package dev.move.gps.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RecordResponse {

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private final LocalDateTime dateTime;

    private final String location;

    private final int step;

    private final int distance;
}
