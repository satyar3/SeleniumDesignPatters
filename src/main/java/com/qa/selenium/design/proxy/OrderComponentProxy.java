package com.qa.selenium.design.proxy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentProxy implements IOrderComponent
{
	private static List<String> EXCLUDED = Arrays.asList("PROD","STAGING");
	private IOrderComponent orderComponent;
	
	public OrderComponentProxy(WebDriver driver)
	{
		String currentENV = System.getProperty("env");
		PageFactory.initElements(driver, this);
		if(!EXCLUDED.contains(currentENV))
		{
			this.orderComponent = new OrderComponentsReal(driver);
		}
	}

	@Override
	public String placeOrder()
	{
		if(Objects.nonNull(this.orderComponent))
			return this.orderComponent.placeOrder();
		else
			return "SKIPPED";
	}

}
