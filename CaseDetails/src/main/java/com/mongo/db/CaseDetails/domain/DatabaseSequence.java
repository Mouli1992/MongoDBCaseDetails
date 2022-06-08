package com.mongo.db.CaseDetails.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author chandramouli
 */
@Document(collection = "database_sequence")
@Data
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
    public DatabaseSequence(long seq){
        this.seq = seq;
    }

}
