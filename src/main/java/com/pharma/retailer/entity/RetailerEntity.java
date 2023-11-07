package com.pharma.retailer.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "retailer", schema = "rms_schema")
public class RetailerEntity {

	@Id
	@Column(name = "retailer_guid")
	private UUID retailerGuid;

	@Column(name = "retailer_code")
	private long retailerCode;

	@Column(name = "retailer_company")
	private String retailerCompany;

	@Column(name = "registration_code")
	private String registrationCode;

	@Column(name = "tan_number")
	private String tanNumber;

	@Column(name = "status")
	private String status;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@JsonManagedReference("retailer-store")
	@OneToMany(mappedBy = "retailerEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StoreEntity> storeEntities;

	public RetailerEntity() {

	}

	public RetailerEntity(UUID retailerGuid, long retailerCode, String retailerCompany, String registrationCode,
			String tanNumber, String status, String ownerName, Timestamp createdDate, Timestamp updatedDate,
			List<StoreEntity> storeEntities) {
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
		this.storeEntities = storeEntities;
	}

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

	public List<StoreEntity> getStoreEntities() {
		return storeEntities;
	}

	public void setStoreEntities(List<StoreEntity> storeEntities) {
		this.storeEntities = storeEntities;
	}

}
