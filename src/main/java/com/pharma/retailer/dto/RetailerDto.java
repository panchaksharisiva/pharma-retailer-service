package com.pharma.retailer.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.pharma.retailer.annotation.MandatoryField;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RetailerDto {

	private UUID retailerGuid;

	private long retailerCode;

	@NotNull(message = "retailerCompany cannot be null")
	@Size(min = 2, message = "company name should have atleast 2 characters")
	@MandatoryField
	private String retailerCompany;

	@NotNull(message = "registrationCode cannot be null")
	private String registrationCode;

	@NotNull(message = "tanNumber cannot be null")
	@Min(value = 1, message = "tanNumber must be positive number")
	@Max(value = 99999999, message = "tanNumber cannot be exceed 99999999")
	private String tanNumber;

	@NotNull(message = "status cannot be null")
	@Size(min = 6, max = 8, message = "status must be atleast 4 and max 8")
	private String status;

	@NotNull(message = "OwnerName cannot be null")
	@Size(min = 3, max = 20, message = "OwnerName must be atleast 3 and max 20")
	private String ownerName;

	@FutureOrPresent(message = "createdDate must be FutureOrPresent ")
	private Timestamp createdDate;

	@FutureOrPresent(message = "updatedDate must be FutureOrPresent ")
	private Timestamp updatedDate;

	@NotNull(message = "store cannot be null")
	@Valid
	private List<StoreDto> storeDtos;

	public RetailerDto() {

	}

	public RetailerDto(UUID retailerGuid, long retailerCode, String retailerCompany, String registrationCode,
			String tanNumber, String status, String ownerName, Timestamp createdDate, Timestamp updatedDate,
			List<StoreDto> storeDtos) {
		super();
		this.retailerGuid = retailerGuid;
		this.retailerCode = retailerCode;
		this.retailerCompany = retailerCompany;
		this.registrationCode = registrationCode;
		this.tanNumber = tanNumber;
		this.status = status;
		this.ownerName = ownerName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.storeDtos = storeDtos;
	}

	/*
	 * public RetailerDto(UUID retailerGuid, long retailerCode,
	 * 
	 * @NotNull(message = "retailerCompany cannot be null") String retailerCompany,
	 * 
	 * @NotNull(message = "registrationCode cannot be null") String
	 * registrationCode,
	 * 
	 * @NotNull(message = "tanNumber cannot be null") @Min(value = 1, message =
	 * "tanNumber must be positive number") @Max(value = 99999999, message =
	 * "tanNumber cannot be exceed 99999999") String tanNumber,
	 * 
	 * @NotNull(message = "status cannot be null") @Size(min = 6, max = 8, message =
	 * "status must be atleast 4 and max 8") String status,
	 * 
	 * @NotNull(message = "OwnerName cannot be null") @Size(min = 3, max = 20,
	 * message = "OwnerName must be atleast 3 and max 20") String ownerName,
	 * 
	 * @FutureOrPresent(message = "createdDate must be FutureOrPresent ") Timestamp
	 * createdDate,
	 * 
	 * @FutureOrPresent(message = "updatedDate must be FutureOrPresent ") Timestamp
	 * updatedDate,
	 * 
	 * @NotNull(message = "store cannot be null") @Valid List<StoreDto> storeDtos) {
	 * super(); this.retailerGuid = retailerGuid; this.retailerCode = retailerCode;
	 * this.retailerCompany = retailerCompany; this.registrationCode =
	 * registrationCode; this.tanNumber = tanNumber; this.status = status;
	 * this.ownerName = ownerName; this.createdDate = createdDate; this.updatedDate
	 * = updatedDate; this.storeDtos = storeDtos; }
	 */
	public UUID getRetailerGuid() {
		return retailerGuid;
	}

	public void setRetailerGuid(UUID retailerGuid) {
		this.retailerGuid = retailerGuid;
	}

	public long getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(long retailerCode) {
		this.retailerCode = retailerCode;
	}

	public String getRetailerCompany() {
		return retailerCompany;
	}

	public void setRetailerCompany(String retailerCompany) {
		this.retailerCompany = retailerCompany;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public String getTanNumber() {
		return tanNumber;
	}

	public void setTanNumber(String tanNumber) {
		this.tanNumber = tanNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<StoreDto> getStoreDtos() {
		return storeDtos;
	}

	public void setStoreDtos(List<StoreDto> storeDtos) {
		this.storeDtos = storeDtos;
	}

	@Override
	public String toString() {
		return "RetailerDto [retailerGuid=" + retailerGuid + ", retailerCode=" + retailerCode + ", retailerCompany="
				+ retailerCompany + ", registrationCode=" + registrationCode + ", tanNumber=" + tanNumber + ", status="
				+ status + ", ownerName=" + ownerName + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", storeDtos=" + storeDtos + "]";
	}

}