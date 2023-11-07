package com.pharma.retailer.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

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

@Component
public class RetailerCommandMapper {

	RetailerMapper retailerMapper;

	public RetailerCommandMapper(RetailerMapper retailerMapper) {
		super();
		this.retailerMapper = retailerMapper;
	}

	public RetailerEntity mapToRetailerEntity(RetailerDto retailerDto) {
		if (retailerDto.getRetailerGuid() == null) {
			retailerDto.setRetailerGuid(UUID.randomUUID());
		}
		if (retailerDto.getRetailerCode() == 0) {
			retailerDto.setRetailerCode(retailerMapper.generateCodeIfNotExists());
		}
		var retailerEntity = retailerMapper.dtoToRetailerEntity(retailerDto);
		retailerEntity.setStoreEntities(mapToStoreEntities(retailerDto.getStoreDtos(), retailerEntity));
		return retailerEntity;
	}

	public List<StoreEntity> mapToStoreEntities(List<StoreDto> storeDtos, RetailerEntity retailerEntity) {
		return storeDtos.stream().map(storeDto -> mapToStoreEntity(storeDto, retailerEntity))
				.collect(Collectors.toList());
	}

	public StoreEntity mapToStoreEntity(StoreDto storeDto, RetailerEntity retailerEntity) {
		if (storeDto.getStoreId() == null) {
			storeDto.setStoreId(UUID.randomUUID());
		}
		if (storeDto.getStoreCode() == 0) {
			storeDto.setStoreCode(retailerMapper.generateCodeIfNotExists());
		}
		var storeEntity = retailerMapper.dtoToStoreEntity(storeDto);
		storeEntity.setRetailerEntity(retailerEntity);
		storeEntity.setAddressEntity(mapToAddressEntity(storeDto.getAddressDto(), storeEntity));
		storeEntity.setContactEntities(mapToContactEnities(storeDto.getContactDtos(), storeEntity));
		storeEntity.setStoreTypeEntity(mapToStoreTypeEntity(storeDto.getStoreTypeDto()));
		return storeEntity;
	}

	public StoreTypeEntity mapToStoreTypeEntity(StoreTypeDto storeTypeDto) {
		return retailerMapper.dtoToStoreTypeEntity(storeTypeDto);

	}

	public AddressEntity mapToAddressEntity(AddressDto addressDto, StoreEntity storeEntity) {
		if (addressDto.getAddressId() == 0) {
			addressDto.setAddressId(UUID.randomUUID().hashCode());
		}
		var addressEntity = retailerMapper.dtoToAddressEntity(addressDto);
		addressEntity.setStoreEntity(storeEntity);
		return addressEntity;
	}

	public List<ContactEntity> mapToContactEnities(List<ContactDto> contactDtos, StoreEntity storeEntity) {
		return contactDtos.stream().map(contactDto -> mapToContactEntity(contactDto, storeEntity))
				.collect(Collectors.toList());
	}

	public ContactEntity mapToContactEntity(ContactDto contactDto, StoreEntity storeEntity) {
		if (contactDto.getContactId() == 0) {
			contactDto.setContactId(UUID.randomUUID().hashCode());
		}
		var contactEntity = retailerMapper.dtoToContactEntity(contactDto);
		contactEntity.setStoreEntity(storeEntity);
		return contactEntity;
	}

//Entity to Dto===================================================

	public RetailerDto entityToRetailerDto(RetailerEntity retailerEntity) {
		var retailerDto = retailerMapper.entityToRetailerDto(retailerEntity);
		retailerDto.setStoreDtos(entityToStoreDtos(retailerEntity.getStoreEntities(), retailerEntity));
		retailerEntity.setStoreEntities(mapToStoreEntities(retailerDto.getStoreDtos(), retailerEntity));
		return retailerDto;
	}

	public List<RetailerDto> entityToRetailerDtos(List<RetailerEntity> retailerEntities) {
		return retailerEntities.stream().map(retailerEntity -> entityToRetailerDto(retailerEntity))
				.collect(Collectors.toList());
	}

	public StoreDto entityToStoreDto(StoreEntity storeEntity, RetailerEntity retailerEntity) {
		var storeDto = retailerMapper.entityToStoreDto(storeEntity);
		storeDto.setAddressDto(entityToAddressDto(storeEntity.getAddressEntity(), storeDto));
		storeDto.setContactDtos(entityToContactDtos(storeEntity.getContactEntities(), storeDto));
		storeDto.setStoreTypeDto(entityToStoreTypeDto(storeEntity.getStoreTypeEntity()));
		return storeDto;
	}

	public StoreTypeDto entityToStoreTypeDto(StoreTypeEntity storeTypeEntity) {
		return retailerMapper.entityToStoreTypeDto(storeTypeEntity);

	}

	public List<StoreDto> entityToStoreDtos(List<StoreEntity> storeEntities, RetailerEntity retailerEntity) {
		return storeEntities.stream().map(storeEntity -> entityToStoreDto(storeEntity, retailerEntity))
				.collect(Collectors.toList());

	}

	public AddressDto entityToAddressDto(AddressEntity addressEntity, StoreDto storeDto) {
		var addressDto = retailerMapper.entityToAddressDto(addressEntity);
		return addressDto;
	}

	public List<ContactDto> entityToContactDtos(List<ContactEntity> contactEntities, StoreDto storeDto) {
		return contactEntities.stream().map(contactEntity -> entityToContactDto(contactEntity, storeDto))
				.collect(Collectors.toList());

	}

	public ContactDto entityToContactDto(ContactEntity contactEntity, StoreDto storeDto) {
		var contactDto = retailerMapper.entityToContactDto(contactEntity);
		return contactDto;
	}

}
