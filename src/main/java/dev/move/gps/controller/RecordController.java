package dev.move.gps.controller;

import dev.move.gps.controller.dto.RecordResponse;
import dev.move.gps.entity.Record;
import dev.move.gps.entity.RecordDto;
import dev.move.gps.service.RecordService;
import dev.move.gps.service.dto.GetRecordRequest;
import dev.move.gps.service.dto.SetRecordRequest;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping("/record")
    public List<RecordDto> getRecord(
            @RequestParam @DateTimeFormat(pattern = "yyyyMMddHHmm") LocalDateTime from,
            @RequestParam @DateTimeFormat(pattern = "yyyyMMddHHmm") LocalDateTime to) {
        return recordService.getRecord(new GetRecordRequest(from, to));
    }

    @GetMapping("/recordTotal")
    public RecordDto getRecordTotal(
            @RequestParam @DateTimeFormat(pattern = "yyyyMMddHHmm") LocalDateTime from,
            @RequestParam @DateTimeFormat(pattern = "yyyyMMddHHmm") LocalDateTime to) {
        return recordService.getRecordTotal(new GetRecordRequest(from, to));
    }

    @PostMapping("/record")
    public RecordResponse setRecord(@Valid @RequestBody SetRecordRequest request) {
        Record setRecord = recordService.setRecord(request);
        return new RecordResponse(setRecord.getDateTime(), setRecord.getLocation(),
                setRecord.getStep(), setRecord.getDistance());
    }
}
