package com.mongo.db.CaseDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author chandramouli
 */
@Data
@AllArgsConstructor
public class CaseLog {

    private String logType;
    private String logLongDesc;
    private String logShortDesc;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;
}
