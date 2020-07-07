package com.qa.selenium.design.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.selenium.design.template.Pages.AmazonProductPage;
import com.qa.selenium.design.template.Pages.AmazonResultsPage;
import com.qa.selenium.design.template.Pages.AmazonSearchPage;

public class AmazonShoppingClass extends ShoppingTemplate
{

	private final WebDriver driver;
	private final WebDriverWait wait;
	private String product;
	
	private AmazonSearchPage amazonSearchPage;
	private AmazonResultsPage amazonResultPage;
	private AmazonProductPage amazonProductPage;
	
	public AmazonShoppingClass(WebDriver driver, String product)
	{
		this.driver = driver;
		this.product = product;
		this.wait = new WebDriverWait(driver, 30);		
		
		PageFactory.initElements(driver, this);
		this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
		this.amazonResultPage = PageFactory.initElements(driver, AmazonResultsPage.class);
		this.amazonProductPage = PageFactory.initElements(driver, AmazonProductPage.class);
	}

	@Override
	public void lunchSite()
	{	
		this.amazonSearchPage.lauchSite();
	}

	@Override
	public void searchForProduct()
	{
		this.amazonSearchPage.searchForProduct(product);
	}

	@Override
	public void selectProduct()
	{
		this.amazonResultPage.selectProduct();
	}

	@Override
	public void checkPrice()
	{
		this.amazonProductPage.checkPrice();
	}

}
