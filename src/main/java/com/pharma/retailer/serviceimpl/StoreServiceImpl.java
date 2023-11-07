package com.pharma.retailer.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.retailer.dto.RetailerDto;
import com.pharma.retailer.dto.StoreDto;
import com.pharma.retailer.entity.StoreEntity;
import com.pharma.retailer.exception.StoreNotFound;
import com.pharma.retailer.mapper.RetailerCommandMapper;
import com.pharma.retailer.repository.StoreRepository;
import com.pharma.retailer.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private RetailerCommandMapper retailerCommandMapper;

	@Override
	public StoreDto createStore(StoreDto storeDto) {
		return retailerCommandMapper
				.entityToStoreDto(storeRepository.save(retailerCommandMapper.mapToStoreEntity(storeDto, null)), null);
	}

	@Override
	public StoreDto updateStore(StoreDto storeDto) {
		return retailerCommandMapper
				.entityToStoreDto(storeRepository.save(retailerCommandMapper.mapToStoreEntity(storeDto, null)), null);
	}

	@Override
	public StoreDto findByStoreCode(long storeCode) {
		Optional<StoreEntity> storeOptionalEntity = storeRepository.findByStoreCode(storeCode);
		if (storeOptionalEntity.isPresent()) {
			return retailerCommandMapper.entityToStoreDto(storeOptionalEntity.get(), null);
		} else {
			throw new StoreNotFound("Store Not found with the given store Code" + storeCode);
		}
	}

	@Override
	public void deleteStore(long storeCode) {
		Optional<StoreEntity> storeEntity = storeRepository.findByStoreCode(storeCode);
		if (storeEntity.isPresent()) {
			storeRepository.delete(storeEntity.get());
		} else {
			throw new StoreNotFound("Store Not found with given store code---> " + storeCode);
		}

	}

	@Override
	public List<RetailerDto> retailerAheadSearch(String query) {
		return retailerCommandMapper.entityToRetailerDtos(storeRepository.retailerAheadSearch(query));

	}

}
