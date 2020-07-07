package com.qa.selenium.design.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

public class NotificationValidator extends ElementValidator
{
	
	private final WebElement button;
	private final WebElement notification;
	
	
	public NotificationValidator(final WebElement button, final WebElement notification)
	{
		this.button = button;
		this.notification = notification;
	}

	@Override
	public boolean validate()
	{
		this.button.click();
		boolean appearanceResult = this.notification.isDisplayed();
		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
		boolean disappearanceResult = this.notification.isDisplayed();
		return appearanceResult && !disappearanceResult;
	}

}
