package com.qa.selenium.design.test.decorator;

import java.util.function.Consumer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.selenium.design.decorator.Dashboard;
import com.qa.selenium.design.test.BaseTest;

public class DashboardPageTest extends BaseTest
{
	Dashboard dashboard;
	
	@BeforeTest
	public void setDashboardPage()
	{
		this.dashboard = new Dashboard(driver);
	}
	
	@Test(dataProvider = "testData")
	public void roleTest(Consumer<Dashboard> consumer)
	{
		dashboard.goTo();
		consumer.accept(dashboard);
	}
	
	@DataProvider
	public Object[] testData()
	{
		return new Object[]{
				
			Decorators.guestPage,
			Decorators.suPage,
			Decorators.adminPage
		};
	}
}
