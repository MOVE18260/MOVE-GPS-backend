package dev.move.gps.repository;

import dev.move.gps.entity.RecordDto;
import java.time.LocalDateTime;
import java.util.List;

public interface RecordRepositoryCustom {

    List<RecordDto> findAllRecordByDateTimeBetween(LocalDateTime from, LocalDateTime to);

    RecordDto findRecordTotalByDateTimeBetween(LocalDateTime from, LocalDateTime to);
}
