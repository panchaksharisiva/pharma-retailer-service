package com.pharma.retailer.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import com.pharma.retailer.dto.AddressDto;
import com.pharma.retailer.dto.ContactDto;
import com.pharma.retailer.dto.RetailerDto;
import com.pharma.retailer.dto.StoreDto;
import com.pharma.retailer.dto.StoreTypeDto;
import com.pharma.retailer.entity.AddressEntity;
import com.pharma.retailer.entity.ContactEntity;
import com.pharma.retailer.entity.RetailerEntity;
import com.pharma.retailer.entity.StoreEntity;
import com.pharma.retailer.entity.StoreTypeEntity;

@Mapper(componentModel = "spring")
public interface RetailerMapper {

	public RetailerEntity dtoToRetailerEntity(RetailerDto retailerDto);

	public StoreEntity dtoToStoreEntity(StoreDto storeDto);

	public StoreTypeEntity dtoToStoreTypeEntity(StoreTypeDto storeTypeDto);

	public AddressEntity dtoToAddressEntity(AddressDto addressDto);

	public ContactEntity dtoToContactEntity(ContactDto contactDto);

//=================================================================
	public RetailerDto entityToRetailerDto(RetailerEntity retailerEntity);

	public StoreDto entityToStoreDto(StoreEntity storeEntity);

	public AddressDto entityToAddressDto(AddressEntity addressEntity);

	public ContactDto entityToContactDto(ContactEntity contactEntity);

	public StoreTypeDto entityToStoreTypeDto(StoreTypeEntity storeTypeEntity);

	default Long generateCodeIfNotExists() {
		long min = 100_000L;
		long max = 999_999L;
		return min + (long) (Math.random() * (max - min + 1));
	}
	
	public default int getId(int id) {
		if (id <= 0)
			id = UUID.randomUUID().hashCode();
		System.out.println("id from UUID--->" + id);
		return id;
	}

}

