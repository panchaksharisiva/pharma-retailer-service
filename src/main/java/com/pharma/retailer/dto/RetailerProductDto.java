package com.pharma.retailer.dto;

import java.time.LocalDate;

public class RetailerProductDto {

	private String retailerProductUid;
	private long retailerCode;
	private int quantity;
	private double ptr;
	private double mrp;
	private long storeCode;
	private long productCode;
	private LocalDate expiryDate;
	private LocalDate manufacturedDate;
	private int reOrderLevel;
	private String productName;

	public RetailerProductDto() {
	}

	public RetailerProductDto(String retailerProductUid, long retailerCode, int quantity, double ptr, double mrp,
			long storeCode, long productCode, LocalDate expiryDate, LocalDate manufacturedDate, int reOrderLevel,
			String productName) {
		this.retailerProductUid = retailerProductUid;
		this.retailerCode = retailerCode;
		this.quantity = quantity;
		this.ptr = ptr;
		this.mrp = mrp;
		this.storeCode = storeCode;
		this.productCode = productCode;
		this.expiryDate = expiryDate;
		this.manufacturedDate = manufacturedDate;
		this.reOrderLevel = reOrderLevel;
		this.productName = productName;
	}

	public String getRetailerProductUid() {
		return retailerProductUid;
	}

	public void setRetailerProductUid(String retailerProductUid) {
		this.retailerProductUid = retailerProductUid;
	}

	public long getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(long retailerCode) {
		this.retailerCode = retailerCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPtr() {
		return ptr;
	}

	public void setPtr(double ptr) {
		this.ptr = ptr;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public long getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(long storeCode) {
		this.storeCode = storeCode;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public int getReOrderLevel() {
		return reOrderLevel;
	}

	public void setReOrderLevel(int reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "RetailerProductDto [retailerProductUid=" + retailerProductUid + ", retailerCode=" + retailerCode
				+ ", quantity=" + quantity + ", ptr=" + ptr + ", mrp=" + mrp + ", storeCode=" + storeCode
				+ ", productCode=" + productCode + ", expiryDate=" + expiryDate + ", manufacturedDate="
				+ manufacturedDate + ", reOrderLevel=" + reOrderLevel + ", productName=" + productName + "]";
	}

}
