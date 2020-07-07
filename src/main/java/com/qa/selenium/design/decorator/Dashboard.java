package com.qa.selenium.design.decorator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dashboard
{
	private final WebDriver driver;
	
	@FindBy(id="role")
	private WebElement role;
	
	@FindBy(css="div.guest")
	private List<WebElement> guestComponents;
	
	@FindBy(css="div.superuser")
	private List<WebElement> superUserComponents;
	
	@FindBy(css="div.admin")
	private List<WebElement> adminComponents;
	
	public Dashboard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void goTo()
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
	}
	
	public void selectRole(String roleName)
	{
		Select select = new Select(role);
		select.selectByValue(roleName);
	}
	
	public List<WebElement> getAdminComponents()
	{
		return adminComponents;
	}
	
	public List<WebElement> getSuperUserComponents()
	{
		return superUserComponents;
	}
	
	public List<WebElement> getGuestComponents()
	{
		return guestComponents;
	}
}
