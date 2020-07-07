package com.qa.selenium.design.strategy;

import java.util.Map;

public interface PaymentOption
{
	void pay(Map<String, String> paymentDetails);
}
