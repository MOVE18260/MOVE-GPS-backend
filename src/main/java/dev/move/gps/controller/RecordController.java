package dev.move.gps.controller;

import dev.move.gps.controller.dto.RecordResponse;
import dev.move.gps.entity.Record;
import dev.move.gps.service.RecordService;
import dev.move.gps.service.dto.RecordRequest;
import java.time.LocalDateTime;
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
    public RecordResponse findRecord(
            @RequestParam @DateTimeFormat(pattern = "yyyyMMddHHmm") LocalDateTime dateTime) {
        Record foundRecord = recordService.findRecord(dateTime);
        return new RecordResponse(foundRecord.getDateTime(), foundRecord.getLocation(),
                foundRecord.getStep(), foundRecord.getDistance());
    }

    @PostMapping("/record")
    public RecordResponse setRecord(@Valid @RequestBody RecordRequest recordRequest) {
        Record setFound = recordService.setRecord(recordRequest);
        return new RecordResponse(setFound.getDateTime(), setFound.getLocation(),
                setFound.getStep(), setFound.getDistance());
    }
}
