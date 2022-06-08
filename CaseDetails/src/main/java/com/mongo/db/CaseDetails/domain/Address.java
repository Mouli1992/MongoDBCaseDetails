package com.mongo.db.CaseDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chandramouli
 */
@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String postCode;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
}
