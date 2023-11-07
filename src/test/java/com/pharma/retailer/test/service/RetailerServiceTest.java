package com.pharma.retailer.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharma.retailer.dto.RetailerDto;
import com.pharma.retailer.entity.RetailerEntity;
import com.pharma.retailer.exception.RetailerNotFound;
import com.pharma.retailer.mapper.RetailerCommandMapper;
import com.pharma.retailer.repository.RetailerRepository;
import com.pharma.retailer.serviceimpl.RetailerServiceImpl;

@SpringBootTest
@ExtendWith(value = { MockitoExtension.class })
public class RetailerServiceTest {

	@InjectMocks
	RetailerServiceImpl retailerServiceImpl;

	@Mock
	RetailerRepository retailerRepository;

	@MockBean
	RetailerCommandMapper retailerCommandMapper;

	RetailerDto retailerDto;

	ObjectMapper objectMapper = new ObjectMapper();

	String retailerJson = null;

	@BeforeEach
	public void setUp() throws StreamReadException, DatabindException, IOException {
		retailerDto = buildRetailerDto();
		System.out.println("retailerDto--" + retailerDto.toString());
		retailerJson = buildRetailerJson();
	}

	public RetailerDto buildRetailerDto() throws StreamReadException, DatabindException, IOException {
		return objectMapper.readValue(new ClassPathResource("retailer-mock.json").getFile(), RetailerDto.class);
	}

	public String buildRetailerJson() throws StreamReadException, DatabindException, IOException {
		return objectMapper.writeValueAsString(retailerDto);
	}

	@Test
	public void createRetailerTest() throws IllegalAccessException, InvocationTargetException {

		RetailerEntity retailerEntity = new RetailerEntity();
		BeanUtils.copyProperties(retailerDto, retailerEntity);

		when(retailerCommandMapper.mapToRetailerEntity(retailerDto)).thenReturn(retailerEntity);
		when(retailerRepository.save(any(RetailerEntity.class))).thenReturn(retailerEntity);
		when(retailerCommandMapper.entityToRetailerDto(retailerEntity)).thenReturn(retailerDto);

		retailerServiceImpl.createRetailer(retailerDto);
	}

	@Test
	public void findByRetailerCodeTest() throws IllegalAccessException, InvocationTargetException {
		long retailerCode = 5677;
		RetailerEntity retailerEntity = new RetailerEntity();
		BeanUtils.copyProperties(retailerDto, retailerDto);
		when(retailerRepository.findByRetailerCode(retailerCode)).thenReturn(Optional.of(retailerEntity));
		RetailerDto retailerDto = retailerServiceImpl.findByRetailerCode(retailerCode);
		assertEquals(retailerDto, retailerDto);
	}

	@Test
	public void findByRetailerCodeNotFound() {
		long retailerCode = 456;
		when(retailerRepository.findByRetailerCode(retailerCode)).thenReturn(Optional.empty());
		assertThrows(RetailerNotFound.class, () -> {
			retailerServiceImpl.findByRetailerCode(retailerCode);
		});
	}

	@Test
	public void deleteByRetailerCodeTest() {
		long retailerCode = 789;
		var retailerEntity = new RetailerEntity();
		when(retailerRepository.findByRetailerCode(retailerCode)).thenReturn(Optional.of(retailerEntity));
		retailerServiceImpl.deleteRetailer(retailerCode);
	}

	@Test
	public void deleteByRetailerCodeNotFound() {
		long retailerCode = 789;
		when(retailerRepository.findByRetailerCode(retailerCode)).thenReturn(Optional.empty());
		assertThrows(RuntimeException.class, () -> {
			retailerServiceImpl.deleteRetailer(retailerCode);
		});
	}

	@Test
	public void updateRetailer() throws IllegalAccessException, InvocationTargetException {
		RetailerEntity retailerEntity = new RetailerEntity();
		BeanUtils.copyProperties(retailerDto, retailerEntity);

		when(retailerRepository.save(any(RetailerEntity.class))).thenReturn(retailerEntity);
		when(retailerCommandMapper.mapToRetailerEntity(retailerDto)).thenReturn(retailerEntity);
		when(retailerCommandMapper.entityToRetailerDto(retailerEntity)).thenReturn(retailerDto);

		retailerServiceImpl.updateRetailer(retailerDto);
	}

	@Test
	public void storeAheadSearch() {
		String searchQuery = "query";
		retailerServiceImpl.storeAheadSearch(searchQuery);
	}
}
