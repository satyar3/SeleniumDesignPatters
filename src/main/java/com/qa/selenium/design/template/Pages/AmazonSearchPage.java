package com.qa.selenium.design.template.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage
{
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(css="input.nav-input")
	private WebElement searchBtn;
	
	private final WebDriver driver;
	
	public AmazonSearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void lauchSite()
	{
		this.driver.get("https://www.amazon.com");
		
	}
	
	public void searchForProduct(String product)
	{
		searchBox.sendKeys(product);
		searchBtn.click();
	}
}
