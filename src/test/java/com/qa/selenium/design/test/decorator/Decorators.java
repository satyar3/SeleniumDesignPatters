package com.qa.selenium.design.test.decorator;

import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.selenium.design.decorator.Dashboard;

public class Decorators
{
	private static void shouldDisplay(List<WebElement> elements)
	{
		elements.forEach(el -> Assert.assertTrue(el.isDisplayed()));
	}
	
	private static void shouldNotDisplay(List<WebElement> elements)
	{
		elements.forEach(el -> Assert.assertFalse(el.isDisplayed()));
	}
	
	//Ingredients
	private static final Consumer<Dashboard> adminComponentShouldPresent = d -> shouldDisplay(d.getAdminComponents());
	private static final Consumer<Dashboard> adminComponentShouldNotPresent = d -> shouldNotDisplay(d.getAdminComponents());
	
	private static final Consumer<Dashboard> suComponentShouldPresent = d -> shouldDisplay(d.getSuperUserComponents());
	private static final Consumer<Dashboard> suComponentShouldNotPresent = d -> shouldNotDisplay(d.getSuperUserComponents());
	
	private static final Consumer<Dashboard> guestComponentShouldPresent = d -> shouldDisplay(d.getGuestComponents());
	private static final Consumer<Dashboard> guestComponentShouldNotPresent = d -> shouldNotDisplay(d.getGuestComponents());
	
	//Role Selection
	private static final Consumer<Dashboard> adminSelect = d -> d.selectRole("admin");
	private static final Consumer<Dashboard> suSelect = d -> d.selectRole("superuser");
	private static final Consumer<Dashboard> guestSelect = d -> d.selectRole("guest");
	
	//User role pages
	public static final Consumer<Dashboard> guestPage = guestSelect.andThen(guestComponentShouldPresent).andThen(suComponentShouldNotPresent).andThen(adminComponentShouldNotPresent);
	public static final Consumer<Dashboard> suPage = suSelect.andThen(guestComponentShouldPresent).andThen(suComponentShouldPresent).andThen(adminComponentShouldNotPresent);
	public static final Consumer<Dashboard> adminPage = adminSelect.andThen(guestComponentShouldPresent).andThen(suComponentShouldPresent).andThen(adminComponentShouldPresent);
	
}
