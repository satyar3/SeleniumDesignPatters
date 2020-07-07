package com.qa.selenium.design.command;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator
{

	private final WebElement dismissalAlert;
	
	public DismissalAlertValidator(final WebElement dismissalAlert)
	{
		this.dismissalAlert = dismissalAlert;
	}
	
	@Override
	public boolean validate()
	{
		boolean resultBeforeClick = this.dismissalAlert.isDisplayed();
		this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
		
		boolean resultAfterClick;		
		try{
			
			resultAfterClick = dismissalAlert.isDisplayed();
			
		}catch(NoSuchElementException e){
			resultAfterClick = false;
		}		
		
		return resultBeforeClick && (!resultAfterClick);
	}
	
}
