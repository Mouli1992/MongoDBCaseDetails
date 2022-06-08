package com.mongo.db.CaseDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author chandramouli
 */
@Data
@AllArgsConstructor
public class Transactions {
    private LocalDate txnDate;
    private String txnCode;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;
    private long txnAmt;
    private String txnStatus;


}
