package dev.move.gps.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.move.gps.entity.Record;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RecordRequest {

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm") // TODO pattern 변경 불가, 이유 모름
    private final LocalDateTime dateTime;

    @NotBlank
    private final String location;

    @PositiveOrZero
    private final int step;

    @PositiveOrZero
    private final int distance;

    public Record toEntity() {
        return new Record(dateTime, location, step, distance);
    }
}
