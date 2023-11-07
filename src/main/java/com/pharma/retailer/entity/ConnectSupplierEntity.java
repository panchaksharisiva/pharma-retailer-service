package com.pharma.retailer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "connect_supplier", schema = "rms_schema")
public class ConnectSupplierEntity {

	@Id
	@Column(name = "connect_supplier_id")
	private int connectSupplierId;

	@Column(name = "priority")
	private int priority;

	@Column(name = "is_favourite")
	private boolean isFavourite;

	@Column(name = "tp_supplier_code")
	private String tpSupplierCode;

	@JoinColumn(name = "supplier_guid")
	private int supplierGuid;

	@OneToOne
	@JoinColumn(name = "connect_status_id")
	private ConnectStatusEntity connectStatusEnitity;

	@JsonManagedReference("store-connect-supplier")
	@JoinColumn(name = "store_id")
	@ManyToOne // (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private StoreEntity storeEntity;

	public ConnectSupplierEntity() {

	}

	public ConnectSupplierEntity(int connectSupplierId, int priority, boolean isFavourite, String tpSupplierCode,
			int supplierGuid, ConnectStatusEntity connectStatusEnitity, StoreEntity storeEntity) {
		super();
		this.connectSupplierId = connectSupplierId;
		this.priority = priority;
		this.isFavourite = isFavourite;
		this.tpSupplierCode = tpSupplierCode;
		this.supplierGuid = supplierGuid;
		this.connectStatusEnitity = connectStatusEnitity;
		this.storeEntity = storeEntity;
	}

	public int getConnectSupplierId() {
		return connectSupplierId;
	}

	public void setConnectSupplierId(int connectSupplierId) {
		this.connectSupplierId = connectSupplierId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

	public void setFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public String getTpSupplierCode() {
		return tpSupplierCode;
	}

	public void setTpSupplierCode(String tpSupplierCode) {
		this.tpSupplierCode = tpSupplierCode;
	}

	public int getSupplierGuid() {
		return supplierGuid;
	}

	public void setSupplierGuid(int supplierGuid) {
		this.supplierGuid = supplierGuid;
	}

	public ConnectStatusEntity getConnectStatusEnitity() {
		return connectStatusEnitity;
	}

	public void setConnectStatusEnitity(ConnectStatusEntity connectStatusEnitity) {
		this.connectStatusEnitity = connectStatusEnitity;
	}

	public StoreEntity getStoreEntity() {
		return storeEntity;
	}

	public void setStoreEntity(StoreEntity storeEntity) {
		this.storeEntity = storeEntity;
	}

}
