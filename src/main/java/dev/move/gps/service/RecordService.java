package dev.move.gps.service;

import dev.move.gps.entity.Record;
import dev.move.gps.entity.RecordDto;
import dev.move.gps.repository.RecordRepository;
import dev.move.gps.service.dto.GetRecordRequest;
import dev.move.gps.service.dto.SetRecordRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    @Autowired
    private final RecordRepository recordRepository;

    @Transactional
    public Record setRecord(SetRecordRequest recordDto) {
        return recordRepository.save(recordDto.toEntity());
    }

    public List<RecordDto> getRecord(GetRecordRequest request) {
        return recordRepository.findAllRecordByDateTimeBetween(
                request.getFrom(), request.getTo());
    }

    public RecordDto getRecordTotal(GetRecordRequest request) {
        return recordRepository.findRecordTotalByDateTimeBetween(
                request.getFrom(), request.getTo());
    }
}
