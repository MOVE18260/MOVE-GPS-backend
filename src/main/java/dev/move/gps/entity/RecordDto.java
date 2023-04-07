package dev.move.gps.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RecordDto {

    // INFO 조회할 때 long 으로 조회해서 Long 사용

    private final Long step;
    private final Long distance;

    public RecordDto(Long step, Long distance) {
        this.step = (step == null) ? 0 : step;
        this.distance = (distance == null) ? 0 : distance;
    }
}
