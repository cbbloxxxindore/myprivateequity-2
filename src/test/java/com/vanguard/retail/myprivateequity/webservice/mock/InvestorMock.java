package com.vanguard.retail.myprivateequity.webservice.mock;

import org.hibernate.integrator.spi.Integrator;

import com.vanguard.retail.myprivateequity.webservice.models.Investor;
import com.vanguard.retail.myprivateequity.webservice.models.InvestorRequest;

public class InvestorMock {

	 public static InvestorRequest getIvestorRequest()
	{
		 InvestorRequest investorRequest = new InvestorRequest();
		 investorRequest.setInvestorLegalName("abhijeet");
		 investorRequest.setInvestorShortName("vickey");
		 investorRequest.setParentInvestorId("12");
		 investorRequest.setLimitedPartnerId("123");
		 investorRequest.setParentLongName("abhijeetsingh thakur");
		 
		 return investorRequest;
		
	}
	 public static Investor getIvestor()
		{
			 Investor investor = new Investor();
			 investor.setInvestorLegalName("abhijeet");
			 investor.setInvestorShortName("vickey");
			 investor.setParentInvestorId("12");
			 investor.setLimitedPartnerId("123");
			 investor.setParentLongName("abhijeetsingh thakur");
			 
			 return investor;
			
		}
}
