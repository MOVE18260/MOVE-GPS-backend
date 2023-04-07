package dev.move.gps.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.move.gps.entity.Record;
import dev.move.gps.entity.RecordDto;
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
                "location1", 1, 10));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 2, 0),
                "location2", 2, 21));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 2, 30),
                "location3", 3, 33));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 3, 0),
                "location1", 4, 45));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 1, 3, 30),
                "location2", 5, 57));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 2, 4, 0),
                "location7", 10, 27));
        recordRepository.save(new Record(LocalDateTime.of(2023, 1, 2, 4, 0),
                "location7", 30, 41));
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

    @Test
    @DisplayName("일간 기록 합계 조회 - 2023년 1월 1일 조회")
    void findMemberTotalTest1() throws JsonProcessingException {
        // given
        LocalDate findDate = LocalDate.of(2023, 1, 1);

        LocalDateTime from = findDate.atStartOfDay();
        LocalDateTime to = findDate.atTime(LocalTime.MAX);

        // when
        Object[] result = recordRepository.findMemberTotalByDateTimeBetween(from, to);

        // then - 쿼리 결과 확인
        System.out.println("objects = " + objectMapper.writeValueAsString(result));
    }

    @Test
    @DisplayName("일간 기록 합계 조회 - 2023년 1월 2일 조회")
    void findMemberTotalTest2() throws JsonProcessingException {
        // given
        LocalDate findDate = LocalDate.of(2023, 1, 2);

        LocalDateTime from = findDate.atStartOfDay();
        LocalDateTime to = findDate.atTime(LocalTime.MAX);

        // when
        Object[] result = recordRepository.findMemberTotalByDateTimeBetween(from, to);

        // then - 쿼리 결과 확인
        System.out.println("objects = " + objectMapper.writeValueAsString(result));
    }

    // INFO 직접 조회하면 Long 타입으로 DTO 를 받지만, Querydsl 은 Integer 로 받아서 주석 처리
//    @Test
//    @DisplayName("일간 기록 합계 조회 - 2023년 1월 3일 조회")
//    void findMemberTotalTest() throws JsonProcessingException {
//        // given
//        LocalDate findDate = LocalDate.of(2023, 1, 3);
//
//        LocalDateTime from = findDate.atStartOfDay();
//        LocalDateTime to = findDate.atTime(LocalTime.MAX);
//
//        // when
//        RecordDto dto = recordRepository.findMemberTotalByDateTimeBetween2(from, to).get();
//
//        // then - 쿼리 결과 확인
//        System.out.println("objects = " + dto);
//    }

    @Test
    @DisplayName("일간 기록 합계 조회 with Querydsl")
    void findMemberTotalWithQuerydslTest() {
        // given
        LocalDate findDate = LocalDate.of(2023, 1, 3);

        LocalDateTime from = findDate.atStartOfDay();
        LocalDateTime to = findDate.atTime(LocalTime.MAX);

        // when
        RecordDto memberTotal = recordRepository.findMemberTotal(from, to);

        // then - 쿼리 결과 확인, 1월 3일인 값이 없으므로 0이 나와야 한다.
        System.out.println("memberTotal = " + memberTotal);
    }
}
