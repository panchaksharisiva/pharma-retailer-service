package com.pharma.retailer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact", schema = "rms_schema")
public class ContactEntity {

	@Id
	@Column(name = "contact_id")
	private int contactId;

	@Column(name = "type")
	private String type;

	@Column(name = "value")
	private String value;

	@JsonBackReference("store-contact")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private StoreEntity storeEntity;

	public ContactEntity() {

	}

	public ContactEntity(int contactId, String type, String value, StoreEntity storeEntity) {
		super();
		this.contactId = contactId;
		this.type = type;
		this.value = value;
		this.storeEntity = storeEntity;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public StoreEntity getStoreEntity() {
		return storeEntity;
	}

	public void setStoreEntity(StoreEntity storeEntity) {
		this.storeEntity = storeEntity;
	}

}
