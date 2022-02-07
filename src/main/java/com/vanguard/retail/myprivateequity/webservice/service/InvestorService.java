package com.vanguard.retail.myprivateequity.webservice.service;

import com.vanguard.retail.myprivateequity.webservice.models.Investor;

public interface InvestorService {
 Investor saveInvestor(Investor investor );
	public Investor updateInvestor(Investor investor ,int investorId ); 

}
