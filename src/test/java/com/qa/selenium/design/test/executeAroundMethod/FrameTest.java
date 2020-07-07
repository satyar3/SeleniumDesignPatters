package com.qa.selenium.design.test.executeAroundMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.selenium.design.executeAroundMethod.MainPage;
import com.qa.selenium.design.test.BaseTest;

public class FrameTest extends BaseTest
{
	private MainPage mainPage;
	
	@BeforeTest
	public void setUpMainPage()
	{
		mainPage = new MainPage(driver);
	}
	
	@Test
	public void test()
	{
		this.mainPage.goTo();
		
		this.mainPage.onFrameA(a -> a.setFirstname("fn1"));
		this.mainPage.onFrameB(b -> b.setFirstname("fn2"));
		this.mainPage.onFrameC(c -> c.setFirstname("fn3"));
		
		
		this.mainPage.onFrameA(a -> {
			a.setLastName("ln1");
			a.setAddress("Address");
			a.setMessage("MSG");
		});
	}
}
