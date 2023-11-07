package com.pharma.retailer.dto;

import jakarta.validation.constraints.NotNull;

public class StoreTypeDto {

	private int storeTypeId;

	@NotNull(message = "description cannot be null")
	private String description;

	public StoreTypeDto() {

	}

	public StoreTypeDto(int storeTypeId, @NotNull(message = "description cannot be null") String description) {
		super();
		this.storeTypeId = storeTypeId;
		this.description = description;
	}

	public int getStoreTypeId() {
		return storeTypeId;
	}

	public void setStoreTypeId(int storeTypeId) {
		this.storeTypeId = storeTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
