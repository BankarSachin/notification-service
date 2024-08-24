package com.smartbank.notificationservice.enums;

public enum ApiMessage {
	MAIL_SUB_CREDIT("Account Credit Alert"),
	MAIL_SUB_CREDIT_RESPONSE_TEXT("Account Credit Alert Mail Sent Successfully"),
	MAIL_SUB_DEBIT("Account Debit Alert"),
	MAIL_SUB_DEBIT_RESPONSE_TEXT("Account Debit Alert Mail Sent Successfully"),
	MAIL_SUB_TRANSFER("Fund Transfer - To Another Account"),
	MAIL_SUB_TRANSFER_RESPONSE_TEXT("Fund Transfer - To Another Account Alert Mail Sent Successfully"),;
	
	
	private String value;
	
	ApiMessage(String string) {
		value = string;
	}

	public String getValue() {
		return value;
	}

	
	
}
