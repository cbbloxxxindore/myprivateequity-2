package com.vanguard.retail.myprivateequity.webservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanguard.retail.myprivateequity.webservice.dao.InvestorRepo;
import com.vanguard.retail.myprivateequity.webservice.exceptions.MyprivateEquityException;
import com.vanguard.retail.myprivateequity.webservice.models.Investor;
import com.vanguard.retail.myprivateequity.webservice.resource.InvestorResource;
@Service
public class InvestorServiceImpl implements InvestorService {
	public  static final String  CLASS_NAME= InvestorServiceImpl.class.getName()  ; 
	private static final Logger log = LoggerFactory.getLogger(InvestorServiceImpl.class);
	private static final String SAVE_METHOD = "saveInvestor            ";
	private static final String EXCEPTION = " Exception occurred while saving Investor";

@Autowired
InvestorRepo investorRepo ;
	public Investor saveInvestor(Investor investor) {
		StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
		try {
			 log.info(msgBuilder.append("Attemping to save investor  service").toString());
		
		Investor investor2=investorRepo.save(investor);
		log.info(msgBuilder.append("sucessfully  saved investor ").toString());
		return investor2;

		}
		catch (Exception e) {
			log.error(EXCEPTION+e);

throw new MyprivateEquityException("unprocessable entity");
		}

	}
	public Investor updateInvestor(Investor investor ,int investorId ) {
	
		Optional<Investor> optional=investorRepo.findById(investorId);
		if(optional.isPresent())
		{
			
			throw new MyprivateEquityException("unprocessable entity");
		}
	
		Investor investor2=optional.get();
		investor2.setInvestorLegalName("abhijeet");
		investor2.setInvestorShortName("vickey");
		investor2.setParentInvestorId("12");
		investor2.setLimitedPartnerId("123");
		investor2.setParentLongName("abhijeetsingh thakur");
		investor2.setPoid("");
		return null;
	}
	

}
