package com.pharma.retailer.test.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.pharma.retailer.dto.RetailerDto;
import com.pharma.retailer.entity.RetailerEntity;
import com.pharma.retailer.exception.RetailerNotFound;
import com.pharma.retailer.mapper.RetailerCommandMapper;
import com.pharma.retailer.repository.RetailerRepository;
import com.pharma.retailer.serviceimpl.RetailerServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RetailerRepositoryTest {

	@InjectMocks
	private RetailerServiceImpl retailerService;

	@Mock
	private RetailerRepository retailerRepository;

	@Mock
	private RetailerCommandMapper retailerCommandMapper;

	@Test
	public void testFindByRetailerCode_Exists() {
		long retailerCode = 12345L;
		RetailerEntity mockedRetailerEntity = new RetailerEntity();
		mockedRetailerEntity.setRegistrationCode("00012");
		mockedRetailerEntity.setRetailerCode(retailerCode);

		when(retailerRepository.findByRetailerCode(retailerCode)).thenReturn(Optional.of(mockedRetailerEntity));

		RetailerDto mockedRetailerDto = new RetailerDto();
		when(retailerCommandMapper.entityToRetailerDto(mockedRetailerEntity)).thenReturn(mockedRetailerDto);

		RetailerDto result = retailerService.findByRetailerCode(retailerCode);

		assertNotNull(result);
		assertSame(mockedRetailerDto, result);
	}

	@Test
	public void testFindByRetailerCode_NotExists() {
		long retailerCode = 12345L;
		when(retailerRepository.findByRetailerCode(retailerCode)).thenReturn(Optional.empty());
		assertThrows(RetailerNotFound.class, () -> retailerService.findByRetailerCode(retailerCode));
	}
}
