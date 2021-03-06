package com.qa.selenium.design.test.strategy;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Maps;
import com.qa.selenium.design.strategy.CreditCardOption;
import com.qa.selenium.design.strategy.PaymentOption;
import com.qa.selenium.design.strategy.PaymentScreen;
import com.qa.selenium.design.test.BaseTest;

public class PaymentScreenTest extends BaseTest
{
	private PaymentScreen paymentScreen;
	
	@BeforeTest
	public void setPaymetScreen()
	{
		this.paymentScreen = new PaymentScreen(driver);
	}
	
	@Test(dataProvider = "testData")
	public void paymentSCreenTest(PaymentOption paymentOption, Map<String,String> paymentDetails)
	{
		this.paymentScreen.goTo();
		this.paymentScreen.getUserInfo().enterDetails("Testln", "Testln", "sasa@gmail.com");
		this.paymentScreen.setPaymentOption(paymentOption);
		this.paymentScreen.getPaymentOption().pay(paymentDetails);
		String orderNumber = this.paymentScreen.getOrderComponent().placeOrder();
		
		System.out.println("Order number :: "+orderNumber);		
	}
	
	
	@DataProvider
	public Object[][] testData()
	{
		
		Map<String, String> ccMap = Maps.newHashMap();
		ccMap.put("cc", "131153");
		ccMap.put("year", "2023");
		ccMap.put("cvv", "123");
		
		
		return new Object[][]{
			
			{new CreditCardOption(), ccMap},
		};
	}
	
}
