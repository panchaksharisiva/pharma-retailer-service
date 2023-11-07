package com.pharma.retailer.service;

import java.util.List;

import com.pharma.retailer.dto.RetailerDto;
import com.pharma.retailer.dto.StoreDto;

public interface StoreService {

	public StoreDto createStore(StoreDto storeDto);

	public StoreDto updateStore(StoreDto storeDto);

	public void deleteStore(long staffCode);

	public StoreDto findByStoreCode(long storeCode);
	
	List<RetailerDto> retailerAheadSearch(String query);

}
