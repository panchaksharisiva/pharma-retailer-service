package com.pharma.retailer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "store_type", schema = "rms_schema")
public class StoreTypeEntity {

	@Id
	@Column(name = "store_type_id")
	private int storeTypeId;

	@Column(name = "description")
	private String description;

	public StoreTypeEntity() {

	}

	public StoreTypeEntity(int storeTypeId, String description) {
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
