package com.pharma.retailer.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="pharma-rms-inventory",url="http://localhost:8086",path="/api/v1/retailerInventory")
public interface RetailerClient {

}
