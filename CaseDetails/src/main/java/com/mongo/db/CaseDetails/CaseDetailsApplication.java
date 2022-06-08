package com.mongo.db.CaseDetails;

import com.mongo.db.CaseDetails.domain.Address;
import com.mongo.db.CaseDetails.domain.CaseDetails;
import com.mongo.db.CaseDetails.domain.Customer;
import com.mongo.db.CaseDetails.repository.CaseRepository;
import com.mongo.db.CaseDetails.service.CaseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CaseDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseDetailsApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner (CaseService caseService){
//		Address address = new Address("United Kingdom",
//				"Southampton","SO18 2NU",
//				"Add1",
//				"Add2",
//				"add3",
//				"add4",
//				"add5"
//				);
//		Customer customer = new Customer( "Individual",
//				123456789L,
//				"Customer Name",
//				"name@name.com",
//				"agent123",
//				"",
//				LocalDateTime.now(),
//				LocalDateTime.now(),
//				address
//				);
//		List<Customer> customerLst = new ArrayList<Customer>();
//		customerLst.add(customer);
////					this.caseType = caseType;
////			this.createdDate = createdDate;
////			this.updatedDate = updatedDate;
////			this.caseStatus = caseStatus;
////			this.caseCreatedBy = caseCreatedBy;
////			this.caseUpdatedBy = caseUpdatedBy;
////			this.caseLog = caseLog;
////			this.customer = customer;
////			this.transactions = transactions;
//		return args -> {
////			CaseDetails caseDetails = new CaseDetails("caseType",
////					LocalDateTime.now(),
////					LocalDateTime.now(),
////					"Created",
////					"agent123",
////					"agent123",
////					 null,
////					customerLst,
////					null,
////					123456L);
////			caseRepository.insert(caseDetails);
//			System.out.println("Case Sequence "+caseService.getCaseSeqDetails("case_sequence"));
//		};
//
//
//	}
}
