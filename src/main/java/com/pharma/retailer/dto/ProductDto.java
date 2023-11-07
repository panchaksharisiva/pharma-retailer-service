package com.pharma.retailer.dto;

import java.time.LocalDate;

public class ProductDto {
	private String productUid;
	private int productCode;
	private long hnsCode;
	private String productName;
	private String description;
	private String manufacturerName;
	private int manufacturerCode;
	private LocalDate createdDate;
	private String patentCompany;
	private LocalDate patentDate;

	private CategoryDto categoryDto;
	private ProductTypeDto productTypeDto;

	public ProductDto() {
	}

	public ProductDto(String productUid, int productCode, long hnsCode, String productName, String description,
			String manufacturerName, int manufacturerCode, LocalDate createdDate, String patentCompany,
			LocalDate patentDate, CategoryDto categoryDto, ProductTypeDto productTypeDto) {
		super();
		this.productUid = productUid;
		this.productCode = productCode;
		this.hnsCode = hnsCode;
		this.productName = productName;
		this.description = description;
		this.manufacturerName = manufacturerName;
		this.manufacturerCode = manufacturerCode;
		this.createdDate = createdDate;
		this.patentCompany = patentCompany;
		this.patentDate = patentDate;
		this.categoryDto = categoryDto;
		this.productTypeDto = productTypeDto;
	}

	public String getProductUid() {
		return productUid;
	}

	public void setProductUid(String productUid) {
		this.productUid = productUid;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public long getHnsCode() {
		return hnsCode;
	}

	public void setHnsCode(long hnsCode) {
		this.hnsCode = hnsCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public int getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(int manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getPatentCompany() {
		return patentCompany;
	}

	public void setPatentCompany(String patentCompany) {
		this.patentCompany = patentCompany;
	}

	public LocalDate getPatentDate() {
		return patentDate;
	}

	public void setPatentDate(LocalDate patentDate) {
		this.patentDate = patentDate;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	public ProductTypeDto getProductTypeDto() {
		return productTypeDto;
	}

	public void setProductTypeDto(ProductTypeDto productTypeDto) {
		this.productTypeDto = productTypeDto;
	}

	@Override
	public String toString() {
		return "ProductDto [productUid=" + productUid + ", productCode=" + productCode + ", hnsCode=" + hnsCode
				+ ", productName=" + productName + ", description=" + description + ", manufacturerName="
				+ manufacturerName + ", manufacturerCode=" + manufacturerCode + ", createdDate=" + createdDate
				+ ", patentCompany=" + patentCompany + ", patentDate=" + patentDate + ", categoryDto=" + categoryDto
				+ ", productTypeDto=" + productTypeDto + "]";
	}

}
