package com.mongo.db.CaseDetails.service.impl;

import com.mongo.db.CaseDetails.domain.CaseDetails;
import com.mongo.db.CaseDetails.domain.DatabaseSequence;
import com.mongo.db.CaseDetails.repository.CaseRepository;
import com.mongo.db.CaseDetails.repository.CaseSeqRepository;
import com.mongo.db.CaseDetails.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author chandramouli
 */
@Service
@Transactional
public class CaseImpl implements CaseService {

    private CaseRepository caseRepository;
    private MongoTemplate mongoTemplate;
    private CaseSeqRepository caseSeqRepository;
    private MongoOperations mongoOperations;
    @Autowired
    public CaseImpl(CaseRepository caseRepository, MongoTemplate mongoTemplate, CaseSeqRepository caseSeqRepository, MongoOperations mongoOperations) {
        this.caseRepository = caseRepository;
        this.mongoTemplate = mongoTemplate;
        this.caseSeqRepository = caseSeqRepository;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public CaseDetails insertCaseDetails(CaseDetails caseDetails) {
        caseDetails.setCaseId(getCaseSeqDetails("case_sequence"));
        return caseRepository.save(caseDetails);

    }

    @Override
    public CaseDetails updateCaseDetails(CaseDetails caseDetails) {
        return caseRepository.save(caseDetails);
    }

    @Override
    public CaseDetails retrieveCaseDetails(Long caseId) {
        return caseRepository.findCaseDetailsByCaseId(caseId).get();
    }

    @Override
    public long getCaseSeqDetails(String seqName) {

//        System.out.println("Inside getCaseSeqDetails Service");
//        Query findQuery = new Query();
//        findQuery.addCriteria(Criteria.where("_id").is(seqName));
//        Update updateQuery = new Update();
//        updateQuery.inc("seq",1);
//        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions().options().returnNew(true).upsert(true);
//        DatabaseSequence seq = mongoTemplate.findAndModify(findQuery,updateQuery,findAndModifyOptions,DatabaseSequence.class);

        DatabaseSequence sequence = mongoOperations.findAndModify(Query.query(Criteria.where("_id").is(seqName)),
                new Update().inc("seq",1), FindAndModifyOptions.options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(sequence) ? sequence.getSeq() : 1;

    }

}
