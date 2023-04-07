package dev.move.gps.repository;

import dev.move.gps.entity.Record;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long>, RecordRepositoryCustom {

    // JPQL : SELECT r FROM Record r WHERE r.dateTime BETWEEN :from and :to
    List<Record> findAllByDateTimeBetween(LocalDateTime from, LocalDateTime to);
}
