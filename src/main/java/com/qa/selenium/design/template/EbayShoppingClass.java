package com.qa.selenium.design.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayShoppingClass extends ShoppingTemplate
{

	private final WebDriver driver;
	private final WebDriverWait wait;
	private String product;
	
	public EbayShoppingClass(WebDriver driver, String product)
	{
		this.driver = driver;
		this.product = product;
		this.wait = new WebDriverWait(driver, 30);
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="gh-ac")
	private WebElement searchBox;
	
	@FindBy(id="gh-btn")
	private WebElement searchBtn;

	@FindBy(css="div.s-item_info_a")
	private WebElement item;
	
	@FindBy(id="prcIsum")
	private WebElement price;
	
	@Override
	public void lunchSite()
	{
		this.driver.get("https://www.ebay.com");
		
	}

	@Override
	public void searchForProduct()
	{
		searchBox.sendKeys(this.product);
		searchBtn.click();
	}

	@Override
	public void selectProduct()
	{
		this.wait.until(driver -> item.isDisplayed());
		item.click();
		
	}

	@Override
	public void checkPrice()
	{
		this.wait.until(driver -> item.isDisplayed());
		String price = item.getText();
		
		System.out.println("Prodcut Price in Amazon :: "+price);
	}

}
