package com.qa.selenium.design.command;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	private final WebDriver driver;
	
	//Buttons
	@FindBy(css="div.button-box button.btn-info")
	private WebElement infoBtn;
	
	@FindBy(css="div.button-box button.btn-warning")
	private WebElement warningBtn;
	
	@FindBy(css="div.button-box button.btn-success")
	private WebElement successBtn;
	
	@FindBy(css="div.button-box button.btn-danger")
	private WebElement dangerBtn;
	
	//Alerts
	@FindBy(css="div.jq-icon-info")
	private WebElement infoAlert;

	@FindBy(css="div.jq-icon-warning")
	private WebElement warningAlert;
	
	@FindBy(css="div.jq-icon-success")
	private WebElement successAlert;
	
	@FindBy(css="div.jq-icon-error")
	private WebElement errorAlert;
	
	//Notifications
	@FindBy(css=".container-fluid >div:nth-child(3) .row >div:nth-child(2) .alert-info")
	private WebElement dismissInfoAlert;
	
	@FindBy(css=".container-fluid >div:nth-child(3) .row >div:nth-child(2) .alert-success")
	private WebElement dismissSuccessAlert;
	
	@FindBy(css=".container-fluid >div:nth-child(3) .row >div:nth-child(2) .alert-danger")
	private WebElement dismissDangerAlert;
	
	@FindBy(css=".container-fluid >div:nth-child(3) .row >div:nth-child(2) .alert-warning")
	private WebElement dismissWarnAlert;
	
	
	 public HomePage(final WebDriver driver)
	 {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }	 
	 
	 public void goTo()
	 {
		 this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
	 }
	 
	 public  List<ElementValidator> getElementValidators()
	 {
		 return Arrays.asList(		
				 
				 	//Alert validation
				 	new NotificationValidator(infoBtn, infoAlert),
				 	new NotificationValidator(successBtn, successAlert),
				 	new NotificationValidator(warningBtn, warningAlert),
				 	new NotificationValidator(dangerBtn, errorAlert),
				 	
				 	//Dismiss validation
				 	new DismissalAlertValidator(dismissInfoAlert),
				 	new DismissalAlertValidator(dismissSuccessAlert),
				 	new DismissalAlertValidator(dismissWarnAlert),
				 	new DismissalAlertValidator(dismissDangerAlert)
				 );
	 }
}
