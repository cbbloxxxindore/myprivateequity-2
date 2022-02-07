package com.vanguard.retail.myprivateequity.webservice.resource;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vanguard.retail.myprivateequity.webservice.exceptions.MyprivateEquityException;
import com.vanguard.retail.myprivateequity.webservice.models.Investor;
import com.vanguard.retail.myprivateequity.webservice.models.InvestorRequest;
import com.vanguard.retail.myprivateequity.webservice.service.InvestorService;

@RestController
public class InvestorResource {
	public  static final String  CLASS_NAME= InvestorResource.class.getName()  ; 
	private static final Logger log = LoggerFactory.getLogger(InvestorResource.class);
	private static final String SAVE_METHOD = "createInvestor";
	private static final String EXCEPTION = " Exception occurred while saving Investor";

@Autowired
	InvestorService investorService;
@PostMapping("/investors")
	 ResponseEntity<String >createInvestor(@Valid @RequestBody InvestorRequest investorRequest)
	 {
	StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
	try {
		 log.info(msgBuilder.append("Attemping to save investor  resource").toString());
	
		Investor investor	=getInvestor(investorRequest);
		 investorService.saveInvestor(investor);
			log.info(msgBuilder.append("sucessfully  saved investor ").toString());

		 return ResponseEntity.ok("investor has created");
	}
		 catch (Exception e) {
				log.error(EXCEPTION+e);

	throw new MyprivateEquityException("unprocessable entity");
			} 
		 
	 }
	 Investor getInvestor( InvestorRequest investorRequest)
	 {
		 Investor investor= new Investor();
		 investor.setInvestorId(123);
		 investor.setEndDate(LocalDateTime.now());
		 investor.setInvestorLegalName(investorRequest.getInvestorLegalName());
		 investor.setInvestorShortName(investorRequest.getInvestorShortName());
		 investor.setInvestorStatus("Active");
		 investor.setLimitedPartnerId(investorRequest.getLimitedPartnerId());
		 investor.setParentInvestorId(investorRequest.getParentInvestorId());
		 investor.setVersionId("1212");
		 investor.setVbaAccountNumber("1212");
		 investor.setPoid("234");
		 investor.setParentLongName(investorRequest.getParentLongName());
		 return investor;
		 
	 }

}
