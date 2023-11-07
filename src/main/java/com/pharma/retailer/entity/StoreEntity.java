package com.pharma.retailer.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "store", schema = "rms_schema")
public class StoreEntity {

	@Id
	@Column(name = "store_id")
	private UUID storeId;

	private String name;

	@Column(name = "store_code")
	private long storeCode;

	private String area;

	@Column(name = "gstn_number")
	private String gstnNumber;

	@JsonManagedReference("store-licence")
	@OneToMany(mappedBy = "storeEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LicenceEntity> licenceEntities;

	@OneToOne
	@JoinColumn(name = "store_type_id")
	private StoreTypeEntity storeTypeEntity;

	@JsonBackReference("retailer-store")
	@JoinColumn(name = "retailer_guid")
	@ManyToOne(fetch = FetchType.LAZY)
	private RetailerEntity retailerEntity;

	@OneToOne(mappedBy = "storeEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AddressEntity addressEntity;

	@JsonManagedReference("store-contact")
	@OneToMany(mappedBy = "storeEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ContactEntity> contactEntities;

//	@JsonManagedReference("store-staff")
//	@OneToMany(mappedBy = "storeEntity")
//	private List<StaffEntity> staffEntities;

	@JsonManagedReference("store-connect_supplier")
	@OneToMany(mappedBy = "storeEntity")
	private List<ConnectSupplierEntity> connectSupplierEntities;

	public StoreEntity() {

	}

	public StoreEntity(UUID storeId, String name, long storeCode, String area, String gstnNumber,
			List<LicenceEntity> licenceEntities, StoreTypeEntity storeTypeEntity, RetailerEntity retailerEntity,
			AddressEntity addressEntity, List<ContactEntity> contactEntities,
			List<ConnectSupplierEntity> connectSupplierEntities) {
		super();
		this.storeId = storeId;
		this.name = name;
		this.storeCode = storeCode;
		this.area = area;
		this.gstnNumber = gstnNumber;
		this.licenceEntities = licenceEntities;
		this.storeTypeEntity = storeTypeEntity;
		this.retailerEntity = retailerEntity;
		this.addressEntity = addressEntity;
		this.contactEntities = contactEntities;
		this.connectSupplierEntities = connectSupplierEntities;
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

	public List<LicenceEntity> getLicenceEntities() {
		return licenceEntities;
	}

	public void setLicenceEntities(List<LicenceEntity> licenceEntities) {
		this.licenceEntities = licenceEntities;
	}

	public StoreTypeEntity getStoreTypeEntity() {
		return storeTypeEntity;
	}

	public void setStoreTypeEntity(StoreTypeEntity storeTypeEntity) {
		this.storeTypeEntity = storeTypeEntity;
	}

	public RetailerEntity getRetailerEntity() {
		return retailerEntity;
	}

	public void setRetailerEntity(RetailerEntity retailerEntity) {
		this.retailerEntity = retailerEntity;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public List<ContactEntity> getContactEntities() {
		return contactEntities;
	}

	public void setContactEntities(List<ContactEntity> contactEntities) {
		this.contactEntities = contactEntities;
	}

	public List<ConnectSupplierEntity> getConnectSupplierEntities() {
		return connectSupplierEntities;
	}

	public void setConnectSupplierEntities(List<ConnectSupplierEntity> connectSupplierEntities) {
		this.connectSupplierEntities = connectSupplierEntities;
	}

}
