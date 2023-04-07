package dev.move.gps.repository;

import dev.move.gps.entity.RecordDto;
import java.time.LocalDateTime;

public interface RecordRepositoryCustom {

    RecordDto findMemberTotal(LocalDateTime from, LocalDateTime to);
}
