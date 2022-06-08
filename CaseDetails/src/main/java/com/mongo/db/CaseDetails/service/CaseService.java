package com.mongo.db.CaseDetails.service;

import com.mongo.db.CaseDetails.domain.CaseDetails;

/**
 * @author chandramouli
 */
public interface CaseService {

    public CaseDetails insertCaseDetails(CaseDetails caseDetails);
    public CaseDetails updateCaseDetails(CaseDetails caseDetails);
    public CaseDetails retrieveCaseDetails(Long caseId);
    public long getCaseSeqDetails(String seqName);
}
