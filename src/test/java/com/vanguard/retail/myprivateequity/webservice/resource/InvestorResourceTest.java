package com.vanguard.retail.myprivateequity.webservice.resource;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.junit.JUnitTestRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanguard.retail.myprivateequity.webservice.exceptions.MyprivateEquityException;
import com.vanguard.retail.myprivateequity.webservice.mock.InvestorMock;
import com.vanguard.retail.myprivateequity.webservice.models.Investor;
import com.vanguard.retail.myprivateequity.webservice.models.InvestorRequest;
import com.vanguard.retail.myprivateequity.webservice.service.InvestorService;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Category(JUnitTestRule.class)
public class InvestorResourceTest
{
	@Mock
	InvestorService investorService;
	
	@InjectMocks InvestorResource investorResource ;
	@Test
public	 void createInvestorSucess()
	 {
		InvestorRequest investorRequest	=InvestorMock.getIvestorRequest();
	Investor investor	=InvestorMock.getIvestor();
	when(investorService.saveInvestor(any())).thenReturn(investor);
		ResponseEntity<String > responseEntity=investorResource.createInvestor(investorRequest);
		 assertNotNull(responseEntity);
	 }
	@Test(expected =MyprivateEquityException.class )
	public void createInvestorwithMyprivateEquityException() throws Exception
	{
		InvestorRequest investorRequest	=InvestorMock.getIvestorRequest();

			doThrow(MyprivateEquityException.class).when(investorService).saveInvestor(any());//updateInvestor(any(), anyInt());

			ResponseEntity<String > responseEntity= investorResource.createInvestor(investorRequest);
			assertNotNull(responseEntity);
	}
}
