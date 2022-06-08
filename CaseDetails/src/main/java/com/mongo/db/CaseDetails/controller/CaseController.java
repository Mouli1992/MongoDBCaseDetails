package com.mongo.db.CaseDetails.controller;

import com.mongo.db.CaseDetails.domain.CaseDetails;
import com.mongo.db.CaseDetails.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chandramouli
 */

@RestController
@RequestMapping("api/v1/")
@ControllerAdvice
public class CaseController {

    @Autowired
    private CaseService caseService;
   @PostMapping("/CaseDetails")
    public ResponseEntity<?> saveCaseDetails(@Valid @RequestBody  CaseDetails caseDetails){
       return new ResponseEntity<>(caseService.insertCaseDetails(caseDetails), HttpStatus.OK) ;
    }

    @PutMapping("/updateCaseDetails")
    public ResponseEntity<?> updateCaseDetails(@Valid @RequestBody  CaseDetails caseDetails){
       return new ResponseEntity<>(caseService.updateCaseDetails(caseDetails),HttpStatus.OK);
    }

    @GetMapping("/getCaseDetails{caseId}")
    public ResponseEntity<?>  getCaseDetailsWithPathVariable(@PathVariable long caseId){
       return new  ResponseEntity<>(caseService.retrieveCaseDetails(caseId),HttpStatus.OK);
    }

    @GetMapping("/getCaseDetails")
    public ResponseEntity<?>  getCaseDetailsWithRequestParam(@RequestParam long caseId){
        return new  ResponseEntity<>(caseService.retrieveCaseDetails(caseId),HttpStatus.OK);
    }

    @GetMapping("/getSequence")
    public long getSequenceDetails(@RequestParam String seqName){
       return caseService.getCaseSeqDetails(seqName);
    }



}
