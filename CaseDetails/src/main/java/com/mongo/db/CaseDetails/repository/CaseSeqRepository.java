package com.mongo.db.CaseDetails.repository;

import com.mongo.db.CaseDetails.domain.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author chandramouli
 */
public interface CaseSeqRepository extends MongoRepository<DatabaseSequence,String> {
}
