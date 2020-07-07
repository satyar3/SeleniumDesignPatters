package com.qa.selenium.design.template.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage
{
	@FindBy(id="priceblock ourprice")
	private WebElement priceOfProduct;	
	
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public AmazonProductPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void checkPrice()
	{
		this.wait.until(driver -> priceOfProduct.isDisplayed());
		String price = priceOfProduct.getText();
		
		System.out.println("Prodcut Price in Amazon :: "+price);
	}
}
