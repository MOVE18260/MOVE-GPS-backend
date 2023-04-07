package dev.move.gps.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import dev.move.gps.entity.Record;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SetRecordRequest {

    @NotNull
    @PastOrPresent
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @NotBlank
    private String location;

    @PositiveOrZero
    private int step;

    @PositiveOrZero
    private int distance;

    public Record toEntity() {
        return new Record(dateTime, location, step, distance);
    }
}
