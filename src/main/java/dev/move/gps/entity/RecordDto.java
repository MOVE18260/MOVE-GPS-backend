package dev.move.gps.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class RecordDto { // Querydsl 종속을 피하기 위해 @QueryProjection 사용하지 않음

    private int step;
    private int distance;
}
