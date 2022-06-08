package com.mongo.db.CaseDetails.repository;

import com.mongo.db.CaseDetails.domain.CaseDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author chandramouli
 */
public interface CaseRepository extends MongoRepository<CaseDetails,String>{

    Optional<CaseDetails> findCaseDetailsByCaseId( Long caseId);
}
