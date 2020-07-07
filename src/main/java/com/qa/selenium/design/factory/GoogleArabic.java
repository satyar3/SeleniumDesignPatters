package com.qa.selenium.design.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish
{
	
	@FindBy(linkText="العربية")
	private WebElement arabicLink;
	
	@FindBy(css="span.hOoLGe")
	private WebElement keyBoardBtn;
	
	@FindBy(id="kbd")
	private WebElement keyBoard;

	public GoogleArabic(WebDriver driver)
	{
		super(driver);
	}

	@Override
	public void lunchSite()
	{
		this.driver.get("https://www.google.com.sa");
		this.arabicLink.click();		
	}

	@Override
	public void search(String keyword)
	{
		wait.until(dr -> this.keyBoardBtn.isDisplayed());
		this.keyBoardBtn.click();		
		wait.until(dr -> this.keyBoard.isDisplayed());
		super.search(keyword);
	}
}
