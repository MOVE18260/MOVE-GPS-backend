package dev.move.gps.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.move.gps.entity.Record;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class RecordRepositoryTest {

    @Autowired
    private RecordRepository recordRepository;

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @BeforeEach
    void before() {
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 1, 30),
                "location1", 1, 1));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 2, 0),
                "location2", 2, 2));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 2, 30),
                "location3", 3, 3));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 3, 0),
                "location1", 4, 4));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 3, 30),
                "location2", 5, 5));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 2, 4, 0),
                "location7", 10, 20));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 2, 4, 0),
                "location7", 30, 40));
    }

    @Test
    @DisplayName("일간 기록 전체 조회")
    void RecordByPeriodTest() {
        // given
        LocalDate findDate = LocalDate.of(2023, 1, 1);

        LocalDateTime from = findDate.atStartOfDay();
        LocalDateTime to = findDate.atTime(LocalTime.MAX);

        // when
        List<Record> foundRecords = recordRepository.findAllByDateTimeBetween(from, to);

        // then
        assertThat(foundRecords.size()).isEqualTo(5);
        assertThat(foundRecords).extracting("step").contains(1, 2, 3, 4, 5);
    }
}
