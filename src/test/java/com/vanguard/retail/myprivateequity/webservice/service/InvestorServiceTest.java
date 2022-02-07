package com.vanguard.retail.myprivateequity.webservice.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.junit.Test;

import org.junit.experimental.categories.Category;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.junit.JUnitTestRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanguard.retail.myprivateequity.webservice.dao.InvestorRepo;
import com.vanguard.retail.myprivateequity.webservice.exceptions.MyprivateEquityException;
import com.vanguard.retail.myprivateequity.webservice.mock.InvestorMock;
import com.vanguard.retail.myprivateequity.webservice.models.Investor;


@RunWith(SpringRunner.class)
@SpringBootTest
@Category(JUnitTestRule.class)
public class InvestorServiceTest {
	@Mock
	InvestorRepo investorRepositrory;
	@InjectMocks
	InvestorServiceImpl investorServiceImpl;
 @Test
	public void saveInvestorSucess()
 {
		Investor investor	=InvestorMock.getIvestor();
		Investor investor1	=InvestorMock.getIvestor();

		when(investorRepositrory.save(any())).thenReturn(investor1);

		Investor investor2= investorServiceImpl.saveInvestor(investor);
		assertNotNull(investor2);
 }
	@Test(expected =MyprivateEquityException.class )
	public void saveInvestorwithMyprivateEquityException() throws Exception
{
		Investor investor	=InvestorMock.getIvestor();

		doThrow(MyprivateEquityException.class).when(investorRepositrory).save(any());//updateInvestor(any(), anyInt());

		Investor investor2= investorServiceImpl.saveInvestor(investor);
		assertNotNull(investor2);
}

}
