package com.pharma.retailer.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.retailer.dto.RetailerDto;
import com.pharma.retailer.dto.StoreDto;
import com.pharma.retailer.entity.RetailerEntity;
import com.pharma.retailer.exception.RetailerNotFound;
import com.pharma.retailer.mapper.RetailerCommandMapper;
import com.pharma.retailer.repository.RetailerRepository;
import com.pharma.retailer.service.RetailerService;

@Service
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	private RetailerRepository retailerRepository;

	@Autowired
	private RetailerCommandMapper retailerCommandMapper;

	@Override
	public RetailerDto createRetailer(RetailerDto retailerDto) {
		return retailerCommandMapper
				.entityToRetailerDto(retailerRepository.save(retailerCommandMapper.mapToRetailerEntity(retailerDto)));
	}

	@Override
	public RetailerDto findByRetailerCode(long retailerCode) {
		Optional<RetailerEntity> retailerOptionalEntity = retailerRepository.findByRetailerCode(retailerCode);
		if (retailerOptionalEntity.isPresent()) {
			return retailerCommandMapper.entityToRetailerDto(retailerOptionalEntity.get());
		} else {
			throw new RetailerNotFound("Retailer Not found with the given retailer Code---> " + retailerCode);
		}
	}

	@Override
	public void deleteRetailer(long retailerCode) {
		Optional<RetailerEntity> retailerEntity = retailerRepository.findByRetailerCode(retailerCode);
		if (retailerEntity.isPresent()) {
			retailerRepository.delete(retailerEntity.get());
		} else {
			throw new RuntimeException("invalid retailer code");
		}
	}

	@Override
	public RetailerDto updateRetailer(RetailerDto retailerDto) {
		return retailerCommandMapper
				.entityToRetailerDto(retailerRepository.save(retailerCommandMapper.mapToRetailerEntity(retailerDto)));
	}

	@Override
	public List<StoreDto> storeAheadSearch(String searchQuery) {
		return retailerCommandMapper.entityToStoreDtos(retailerRepository.storeAheadSearch(searchQuery), null);
	}

}
