package com.mongo.db.CaseDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author chandramouli
 */
@Data
@AllArgsConstructor
public class Customer {
    //    customerDtl [
//    customer:id
//    customerType:
//    customerName:
//    customerEmailL
//            craetedBy
//    createdDate
//            updatedDate
//
//]

    @NotBlank
    private String customerType;
    @NotBlank
    private long customerId;
    @NotBlank
    private String customerName;
    @Email
    private String customerEmail;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;
    @NotBlank
    private Address address;

}
