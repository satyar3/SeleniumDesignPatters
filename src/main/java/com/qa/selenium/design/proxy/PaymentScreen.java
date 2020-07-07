package com.qa.selenium.design.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreen
{
	private WebDriver driver;
	private UserInformation userInfo;
	private IOrderComponent orderComponent;	
	private PaymentOption paymentOption;
	
	public PaymentScreen(final WebDriver driver)
	{
		this.driver = driver;
		this.userInfo = PageFactory.initElements(driver, UserInformation.class);
		this.orderComponent = new OrderComponentProxy(driver);
	}

	public PaymentOption getPaymentOption()
	{
		return paymentOption;
	}
	
	public void goTo()
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
	}

	public void setPaymentOption(PaymentOption paymentOption)
	{
		this.paymentOption = paymentOption;
		PageFactory.initElements(driver, paymentOption);
	}

	public UserInformation getUserInfo()
	{
		return userInfo;
	}

	public void setUserInfo(UserInformation userInfo)
	{
		this.userInfo = userInfo;
	}

	public IOrderComponent getOrderComponent()
	{
		return this.orderComponent;
	}

	public void setOrderComponent(IOrderComponent orderComponent)
	{
		this.orderComponent = orderComponent;
	}
}
