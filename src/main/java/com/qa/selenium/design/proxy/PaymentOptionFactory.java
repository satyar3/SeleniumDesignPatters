package com.qa.selenium.design.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory
{
	private static final Supplier<PaymentOption> CC = () ->  new CreditCardOption();
	private static final Supplier<PaymentOption> NET_BANKING = () ->  new NetBakingOption();
	
	private static Map<String,Supplier<PaymentOption>> paymentMap = new HashMap<>();
	
	static
	{
		paymentMap.put("cc", CC);
		paymentMap.put("netbanking", NET_BANKING);
	}
	
	public static PaymentOption getPaymentOption(String paymentMode)
	{
		return paymentMap.get(paymentMode).get();
	}
}
