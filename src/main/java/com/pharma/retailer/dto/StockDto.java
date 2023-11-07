package com.pharma.retailer.dto;

import java.sql.Timestamp;

public class StockDto {
	private long stockId;

	private int stockIn;

	private int stockOut;

	private Timestamp lastUpdatedDate;

	public StockDto() {
	}

	public StockDto(long stockId, int stockIn, int stockOut, Timestamp lastUpdatedDate) {
		this.stockId = stockId;
		this.stockIn = stockIn;
		this.stockOut = stockOut;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public int getStockIn() {
		return stockIn;
	}

	public void setStockIn(int stockIn) {
		this.stockIn = stockIn;
	}

	public int getStockOut() {
		return stockOut;
	}

	public void setStockOut(int stockOut) {
		this.stockOut = stockOut;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "StockDto [stockId=" + stockId + ", stockIn=" + stockIn + ", stockOut=" + stockOut + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}
}