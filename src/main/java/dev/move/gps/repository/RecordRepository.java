package dev.move.gps.repository;

import dev.move.gps.entity.Record;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

    Optional<Record> findRecordByDateTime(LocalDateTime dateTime);

    // 일간 기록 조회
    // JPQL : SELECT r FROM Record r WHERE r.dateTime BETWEEN :from and :to
    List<Record> findAllByDateTimeBetween(LocalDateTime from, LocalDateTime to);
}
