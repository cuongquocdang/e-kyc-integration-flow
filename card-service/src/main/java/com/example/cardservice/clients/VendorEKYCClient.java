package com.example.cardservice.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "vendorEKYCClient", url = "http://localhost:8030/v1/e-kyc-vendors/")
public interface VendorEKYCClient {
}
