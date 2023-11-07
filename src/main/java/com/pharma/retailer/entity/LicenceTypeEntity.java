package com.pharma.retailer.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "licence_type", schema = "rms_schema")
public class LicenceTypeEntity {
	@Id
	@Column(name = "licence_type_id")
	private int licenceTypeId;

	@Column(name = "description")
	private String description;

	public LicenceTypeEntity() {

	}

	public LicenceTypeEntity(int licenceTypeId, String description) {
		super();
		this.licenceTypeId = licenceTypeId;
		this.description = description;
	}

	public int getLicenceTypeId() {
		return licenceTypeId;
	}

	public void setLicenceTypeId(int licenceTypeId) {
		this.licenceTypeId = licenceTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
