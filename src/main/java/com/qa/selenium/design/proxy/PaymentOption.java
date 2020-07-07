package com.qa.selenium.design.proxy;

import java.util.Map;

public interface PaymentOption
{
	void pay(Map<String, String> paymentDetails);
}
