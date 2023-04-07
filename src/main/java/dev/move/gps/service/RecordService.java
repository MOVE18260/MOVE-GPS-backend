package dev.move.gps.service;

import dev.move.gps.entity.Record;
import dev.move.gps.repository.RecordRepository;
import dev.move.gps.service.dto.RecordRequest;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecordService {

    @Autowired
    private final RecordRepository recordRepository;

//    @Transactional
//    public Record setRecord(RecordRequest recordDto) {
//        recordRepository.findRecordByDateTime(recordDto.getDateTime()).ifPresent((foundRecord) -> {
//            throw new IllegalArgumentException();
//        });
//
//        return recordRepository.save(recordDto.toEntity());
//    }
//
//    @Transactional(readOnly = true)
//    public Record findRecord(LocalDateTime dateTime) {
//        return recordRepository.findRecordByDateTime(dateTime)
//                .orElseThrow(IllegalArgumentException::new);
//    }
}
