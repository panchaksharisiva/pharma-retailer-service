package com.pharma.retailer.exception;

@SuppressWarnings("serial")
public class RetailerNotFound extends RuntimeException {

	public RetailerNotFound(String message) {
		super(message);
	}
}
