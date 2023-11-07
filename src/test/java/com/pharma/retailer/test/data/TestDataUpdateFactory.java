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

	public class TestDataUpdateFactory {

		public static RetailerDto updateSampleRetailerDto() {
			RetailerDto retailerDto = new RetailerDto();
			retailerDto.setRetailerGuid(UUID.randomUUID());
			retailerDto.setRetailerCode(123467L);
			retailerDto.setRetailerCompany("BBC Retailer");
			retailerDto.setRegistrationCode("REG1234");
			retailerDto.setTanNumber("TAN4567");
			retailerDto.setStatus("Actives");
			retailerDto.setOwnerName("John Does");
			retailerDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			retailerDto.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

			List<StoreDto> storeDtos = new ArrayList<>();
			storeDtos.add(updateSampleStoreDto());
			retailerDto.setStoreDtos(storeDtos);

			return retailerDto;
		}

		public static StoreDto updateSampleStoreDto() {
			StoreDto storeDto = new StoreDto();
			storeDto.setStoreId(UUID.randomUUID());
			storeDto.setName("ABC Medical Store");
			storeDto.setStoreCode(54321L);
			storeDto.setArea("Downtown Area");
			storeDto.setGstnNumber("GST123");
			storeDto.setStoreTypeDto(updateSampleStoreTypeDto());
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
			contactDtos.add(updateSampleContactDto());
			storeDto.setContactDtos(contactDtos);

			return storeDto;
		}

		public static StoreTypeDto updateSampleStoreTypeDto() {
			StoreTypeDto storeTypeDto = new StoreTypeDto();
			storeTypeDto.setStoreTypeId(1);
			storeTypeDto.setDescription("Sample Types");
			return storeTypeDto;
		}

		public static ContactDto updateSampleContactDto() {
			ContactDto contactDto = new ContactDto();
			contactDto.setContactId(1);
			contactDto.setType("mobile");
			contactDto.setValue("123456789");
			return contactDto;
		}
	}

