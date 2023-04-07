package dev.move.gps.repository;

import dev.move.gps.entity.Record;
import dev.move.gps.entity.RecordDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordRepository extends JpaRepository<Record, Long> {

    Optional<Record> findRecordByDateTime(LocalDateTime dateTime);

    // 일간 기록 조회
    // JPQL : SELECT r FROM Record r WHERE r.dateTime BETWEEN :from and :to
    List<Record> findAllByDateTimeBetween(LocalDateTime from, LocalDateTime to);

    @Query(value = "SELECT SUM(r.step), SUM(r.distance) FROM Record r WHERE r.dateTime BETWEEN :from and :to")
    Object[] findMemberTotalByDateTimeBetween(@Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to);

    @Query(value = "SELECT new dev.move.gps.entity.RecordDto(SUM(r.step), SUM(r.distance)) FROM Record r WHERE r.dateTime BETWEEN :from and :to")
    Optional<RecordDto> findMemberTotalByDateTimeBetween2(@Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to);
}
