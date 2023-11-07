/*
 * package com.pharma.retailer.test.controller;
 * 
 * import static org.mockito.Mockito.when; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.io.IOException;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.core.io.ClassPathResource; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 * 
 * import com.fasterxml.jackson.core.exc.StreamReadException; import
 * com.fasterxml.jackson.databind.DatabindException; import
 * com.fasterxml.jackson.databind.ObjectMapper; import
 * com.pharma.retailer.controller.RetailerController; import
 * com.pharma.retailer.dto.RetailerDto; import
 * com.pharma.retailer.service.RetailerService;
 * 
 * @SpringBootTest
 * 
 * @AutoConfigureWebMvc public class RetailerControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @InjectMocks private RetailerController retailerController;
 * 
 * @Mock private RetailerService retailerService;
 * 
 * RetailerDto retailerDto;
 * 
 * ObjectMapper objectMapper = new ObjectMapper();
 * 
 * String retailerJson = null;
 * 
 * @BeforeEach public void setUp() throws StreamReadException,
 * DatabindException, IOException { retailerDto = buildRetailerDto();
 * retailerJson = buildRetailerJson(); }
 * 
 * public RetailerDto buildRetailerDto() throws StreamReadException,
 * DatabindException, IOException { return objectMapper.readValue(new
 * ClassPathResource("retailer-mock.json").getFile(), RetailerDto.class); }
 * 
 * public String buildRetailerJson() throws StreamReadException,
 * DatabindException, IOException { return
 * objectMapper.writeValueAsString(retailerDto); }
 * 
 * @Test public void createRetailerTest() throws Exception {
 * when(retailerService.createRetailer(retailerDto)).thenReturn(retailerDto);
 * 
 * this.mockMvc.perform(post("/api/retailer/v1/create") .content(retailerJson)
 * .contentType(MediaType.APPLICATION_JSON_VALUE)
 * .accept(MediaType.APPLICATION_JSON_VALUE)) .andExpect(status().isOk())
 * .andExpect(MockMvcResultMatchers.jsonPath("$.retailerCode").exists()); }
 * 
 * @Test public void findByRetailerCodeTest() throws Exception {
 * when(retailerService.findByRetailerCode(123456)).thenReturn(retailerDto);
 * this.mockMvc.perform(get("/api/retailer/v1/findByCode/{retailerCode}",
 * 123456) .contentType(MediaType.APPLICATION_JSON_VALUE)
 * .accept(MediaType.APPLICATION_JSON_VALUE)) .andExpect(status().isOk())
 * .andExpect(MockMvcResultMatchers.jsonPath("$.retailerCode").exists()); }
 * 
 * @Test public void findByRetailerCodeNotTest() throws Exception {
 * when(retailerService.findByRetailerCode(345675)).thenReturn(retailerDto);
 * this.mockMvc.perform(get("/api/retailer/v1/findByCode/{retailerCode}",345675)
 * .contentType(MediaType.APPLICATION_JSON_VALUE)
 * .accept(MediaType.APPLICATION_JSON_VALUE)) .andExpect(status().isNotFound())
 * .andExpect(MockMvcResultMatchers.jsonPath("$.retailerCode").doesNotExist());
 * }
 * 
 * @Test public void deleteRetailerTest() throws Exception {
 * Mockito.doNothing().when(retailerService).deleteRetailer(Mockito.anyLong());
 * this.mockMvc .perform(delete("/api/retailer/v1/delete?retailerCode=123456")
 * .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.
 * APPLICATION_JSON_VALUE)) .andExpect(status().isOk()); }
 * 
 * }
 */