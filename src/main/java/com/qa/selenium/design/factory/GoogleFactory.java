package com.qa.selenium.design.factory;

import java.util.HashMap;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

public class GoogleFactory
{
	private static final Function<WebDriver,GooglePage> ENGLISH = driver -> new GoogleEnglish(driver);
	private static final Function<WebDriver,GooglePage> FRENCH = driver -> new GoogleFrench(driver);
	private static final Function<WebDriver,GooglePage> ARABIC = driver -> new GoogleArabic(driver);
	
	private static final HashMap<String, Function<WebDriver,GooglePage>> LANGUAGE_MAP = new HashMap<>();
	
	static{
		LANGUAGE_MAP.put("english", ENGLISH);
		LANGUAGE_MAP.put("french", FRENCH);
		LANGUAGE_MAP.put("arabic", ARABIC);
	}
	
	
	public static GooglePage get(String language, WebDriver driver)
	{
		return LANGUAGE_MAP.get(language).apply(driver);
	}
}
