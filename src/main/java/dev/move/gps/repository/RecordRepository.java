package dev.move.gps.repository;

import dev.move.gps.entity.Record;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

    Optional<Record> findRecordByDateTime(LocalDateTime dateTime);
}
