package com.pharma.retailer.dto;

import jakarta.validation.constraints.NotNull;

public class ContactDto {

	private int contactId;
	@NotNull(message = "please specify contact type")
	private String type;

	@NotNull(message = "please enter the value")
	private String value;

	public ContactDto() {

	}

	public ContactDto(int contactId, @NotNull(message = "please specify contact type") String type,
			@NotNull(message = "please enter the value") String value) {
		super();
		this.contactId = contactId;
		this.type = type;
		this.value = value;
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

}
