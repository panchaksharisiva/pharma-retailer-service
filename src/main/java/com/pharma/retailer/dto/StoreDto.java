package com.pharma.retailer.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StoreDto {

	private UUID storeId;

	@NotNull(message = "name cannot be null")
	@Size(min = 10, max = 30, message = "Name must be atleast 10 and max 30")
	private String name;

	private long storeCode;

	@NotNull(message = "area cannot be null")
	private String area;

	@NotNull(message = "gstnNumber cannot be null")
	@Min(value = 1, message = "gstnNumber must be positive number")
	@Max(value = 99999999, message = "gstnNumber cannot be exceed 99999999")
	private String gstnNumber;

	@NotNull(message = "store should not be nul")
	@Valid
	private StoreTypeDto storeTypeDto;

	private UUID retailerGuid;

	@NotNull(message = "Address should not be nul")
	@Valid
	private AddressDto addressDto;

	@NotNull(message = "Contact should not be nul")
	@Valid
	private List<ContactDto> contactDtos;

	public StoreDto() {

	}

	public StoreDto(UUID storeId,
			@NotNull(message = "name cannot be null") @Size(min = 10, max = 30, message = "Name must be atleast 10 and max 30") String name,
			long storeCode, @NotNull(message = "area cannot be null") String area,
			@NotNull(message = "gstnNumber cannot be null") @Min(value = 1, message = "gstnNumber must be positive number") @Max(value = 99999999, message = "gstnNumber cannot be exceed 99999999") String gstnNumber,
			@NotNull(message = "store should not be nul") @Valid StoreTypeDto storeTypeDto, UUID retailerGuid,
			@NotNull(message = "Address should not be nul") @Valid AddressDto addressDto,
			@NotNull(message = "Contact should not be nul") @Valid List<ContactDto> contactDtos) {
		super();
		this.storeId = storeId;
		this.name = name;
		this.storeCode = storeCode;
		this.area = area;
		this.gstnNumber = gstnNumber;
		this.storeTypeDto = storeTypeDto;
		this.retailerGuid = retailerGuid;
		this.addressDto = addressDto;
		this.contactDtos = contactDtos;
	}

	public UUID getStoreId() {
		return storeId;
	}

	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(long storeCode) {
		this.storeCode = storeCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getGstnNumber() {
		return gstnNumber;
	}

	public void setGstnNumber(String gstnNumber) {
		this.gstnNumber = gstnNumber;
	}

	public StoreTypeDto getStoreTypeDto() {
		return storeTypeDto;
	}

	public void setStoreTypeDto(StoreTypeDto storeTypeDto) {
		this.storeTypeDto = storeTypeDto;
	}

	public UUID getRetailerGuid() {
		return retailerGuid;
	}

	public void setRetailerGuid(UUID retailerGuid) {
		this.retailerGuid = retailerGuid;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public List<ContactDto> getContactDtos() {
		return contactDtos;
	}

	public void setContactDtos(List<ContactDto> contactDtos) {
		this.contactDtos = contactDtos;
	}
}
