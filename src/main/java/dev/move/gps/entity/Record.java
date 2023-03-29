package dev.move.gps.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private String location;

    private int step;

    private int distance;

    public Record(LocalDateTime dateTime, String location, int step, int distance) {
        this.dateTime = dateTime;
        this.location = location;
        this.step = step;
        this.distance = distance;
    }
}
