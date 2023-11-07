package com.pharma.retailer.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "licence", schema = "rms_schema")
public class LicenceEntity {

	@Id
	@Column(name = "licence_id")
	private int licenceId;

	@Column(name = "description")
	private String description;

	@Column(name = "licence_code")
	private String licenceCode;

	@Column(name = "valid_from", columnDefinition = "DATE")
	private Date validFrom;

	@Column(name = "valid_to", columnDefinition = "DATE")
	private Timestamp validTo;

	@Column(name = "status")
	private String status;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@OneToOne
	@JoinColumn(name = "licence_type_id")
	private LicenceTypeEntity licenceTypeEntity;

	@JsonManagedReference("store-licence")
	@JoinColumn(name = "store_id")
	@ManyToOne // (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private StoreEntity storeEntity;

	public LicenceEntity() {

	}

	public LicenceEntity(int licenceId, String description, String licenceCode, Date validFrom, Timestamp validTo,
			String status, Timestamp createdDate, LicenceTypeEntity licenceTypeEntity, StoreEntity storeEntity) {
		super();
		this.licenceId = licenceId;
		this.description = description;
		this.licenceCode = licenceCode;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.status = status;
		this.createdDate = createdDate;
		this.licenceTypeEntity = licenceTypeEntity;
		this.storeEntity = storeEntity;
	}

	public int getLicenceId() {
		return licenceId;
	}

	public void setLicenceId(int licenceId) {
		this.licenceId = licenceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLicenceCode() {
		return licenceCode;
	}

	public void setLicenceCode(String licenceCode) {
		this.licenceCode = licenceCode;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Timestamp getValidTo() {
		return validTo;
	}

	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public LicenceTypeEntity getLicenceTypeEntity() {
		return licenceTypeEntity;
	}

	public void setLicenceTypeEntity(LicenceTypeEntity licenceTypeEntity) {
		this.licenceTypeEntity = licenceTypeEntity;
	}

	public StoreEntity getStoreEntity() {
		return storeEntity;
	}

	public void setStoreEntity(StoreEntity storeEntity) {
		this.storeEntity = storeEntity;
	}

}
