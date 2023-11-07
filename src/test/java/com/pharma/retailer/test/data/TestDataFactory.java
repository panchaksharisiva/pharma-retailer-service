package com.pharma.retailer.test.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.pharma.retailer.dto.AddressDto;
import com.pharma.retailer.dto.ContactDto;
import com.pharma.retailer.dto.RetailerDto;
import com.pharma.retailer.dto.StoreDto;
import com.pharma.retailer.dto.StoreTypeDto;

public class TestDataFactory {

	public static RetailerDto createSampleRetailerDto() {
		RetailerDto retailerDto = new RetailerDto();
		retailerDto.setRetailerGuid(UUID.randomUUID());
		retailerDto.setRetailerCode(12345L);
		retailerDto.setRetailerCompany("ABC Retailer");
		retailerDto.setRegistrationCode("REG123");
		retailerDto.setTanNumber("TAN456");
		retailerDto.setStatus("Active");
		retailerDto.setOwnerName("John Doe");
		retailerDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		retailerDto.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

		List<StoreDto> storeDtos = new ArrayList<>();
		storeDtos.add(createSampleStoreDto());
		retailerDto.setStoreDtos(storeDtos);

		return retailerDto;
	}

	public static StoreDto createSampleStoreDto() {
		StoreDto storeDto = new StoreDto();
		storeDto.setStoreId(UUID.randomUUID());
		storeDto.setName("ABC Medical Store");
		storeDto.setStoreCode(54321L);
		storeDto.setArea("Downtown Area");
		storeDto.setGstnNumber("GST123");
		storeDto.setStoreTypeDto(createSampleStoreTypeDto());
		storeDto.setRetailerGuid(UUID.randomUUID());

		AddressDto addressDto = new AddressDto();
		addressDto.setAddressId(1);
		addressDto.setLine1("123 Main Street");
		addressDto.setLine2("BOA");
		addressDto.setCity("Newyark");
		addressDto.setState("Albhama");
		addressDto.setPostalCode("22256");
		storeDto.setAddressDto(addressDto);

		List<ContactDto> contactDtos = new ArrayList<>();
		contactDtos.add(createSampleContactDto());
		storeDto.setContactDtos(contactDtos);

		return storeDto;
	}

	public static StoreTypeDto createSampleStoreTypeDto() {
		StoreTypeDto storeTypeDto = new StoreTypeDto();
		storeTypeDto.setStoreTypeId(1);
		storeTypeDto.setDescription("Sample Type");
		return storeTypeDto;
	}

	public static ContactDto createSampleContactDto() {
		ContactDto contactDto = new ContactDto();
		contactDto.setContactId(1);
		contactDto.setType("email");
		contactDto.setValue("john@example.com");
		return contactDto;
	}
}