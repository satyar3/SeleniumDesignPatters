package com.qa.selenium.design.template.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonResultsPage
{
	@FindBy(css="span.a-size-medium")
	private WebElement item;

	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public AmazonResultsPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct()
	{
		this.wait.until(driver -> item.isDisplayed());
		item.click();
		
	}
}
