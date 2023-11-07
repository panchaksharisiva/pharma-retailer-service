package com.pharma.retailer.dto;

import java.util.List;

public class RetailerProductQueryDto {

	private RetailerProductDto retailerProductDto;

	private List<StockDto> stockDtos;

	public RetailerProductQueryDto() {
	}

	public RetailerProductQueryDto(RetailerProductDto retailerProductDto, List<StockDto> stockDtos) {
		this.retailerProductDto = retailerProductDto;
		this.stockDtos = stockDtos;
	}

	public RetailerProductDto getRetailerProductDto() {
		return retailerProductDto;
	}

	public void setRetailerProductDto(RetailerProductDto retailerProductDto) {
		this.retailerProductDto = retailerProductDto;
	}

	public List<StockDto> getStockDtos() {
		return stockDtos;
	}

	public void setStockDtos(List<StockDto> stockDtos) {
		this.stockDtos = stockDtos;
	}
}
