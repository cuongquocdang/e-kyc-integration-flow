package com.example.cardservice.clients;

import com.example.cardservice.dtos.VendorEKYCCallingResultDTO;
import com.example.cardservice.dtos.VendorEKYCSearchingRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "vendorEKYCClient", url = "http://localhost:8030/v1/e-kyc-callings")
public interface VendorEKYCClient {

    @PostMapping("/call-log")
    VendorEKYCCallingResultDTO retrieveCallLog(@RequestBody VendorEKYCSearchingRequestDTO requestDTO);
}
