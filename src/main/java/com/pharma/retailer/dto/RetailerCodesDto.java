package com.pharma.retailer.dto;

import java.util.List;

public class RetailerCodesDto {
	
	private List<Long> retailerCodes;

	public RetailerCodesDto(List<Long> retailerCodes) {
		super();
		this.retailerCodes = retailerCodes;
	}

	public List<Long> getRetailerCodes() {
		return retailerCodes;
	}

	public void setRetailerCodes(List<Long> retailerCodes) {
		this.retailerCodes = retailerCodes;
	}

	@Override
	public String toString() {
		return "RetailerCodesDto []";
	}
}
