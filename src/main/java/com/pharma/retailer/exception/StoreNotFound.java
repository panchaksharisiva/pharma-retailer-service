package com.pharma.retailer.exception;

@SuppressWarnings("serial")
public class StoreNotFound extends RuntimeException {

	public StoreNotFound(String message) {
		super(message);
	}
}
