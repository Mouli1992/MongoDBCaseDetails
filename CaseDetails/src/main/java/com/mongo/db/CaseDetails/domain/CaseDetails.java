package com.mongo.db.CaseDetails.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chandramouli
 */
@Data
@Document(collection = "CaseDetails")
@AllArgsConstructor
public class CaseDetails {

    @Id
    @JsonProperty
    private String id;
    @JsonProperty
    @Indexed(unique = true)
    private Long caseId;
    @NotBlank(message = "Case type is mandatory")
    @NotNull(message = "Case type is mandatory")
    @NotEmpty(message = "Case type is mandatory")
    private String caseType;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @NotBlank(message = "Case status is mandatory")
    private String caseStatus;
    private String caseCreatedBy;
    private String caseUpdatedBy;
    private List<CaseLog> caseLog;
    private List<Customer> customer;
    private List<Transactions> transactions;

    public CaseDetails(){}
    public CaseDetails(String caseType, LocalDateTime createdDate, LocalDateTime updatedDate, String caseStatus, String caseCreatedBy, String caseUpdatedBy, List<CaseLog> caseLog, List<Customer> customer, List<Transactions> transactions, Long caseId) {
        this.caseType = caseType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.caseStatus = caseStatus;
        this.caseCreatedBy = caseCreatedBy;
        this.caseUpdatedBy = caseUpdatedBy;
        this.caseLog = caseLog;
        this.customer = customer;
        this.transactions = transactions;
        this.caseId = caseId;
    }

}
