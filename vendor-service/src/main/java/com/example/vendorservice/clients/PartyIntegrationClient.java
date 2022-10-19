package com.example.vendorservice.clients;

import com.example.vendorservice.dtos.EKYCCallingResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "partyIntegrationClient", url = "http://localhost:8020/v1/electronic-know-your-customers")
public interface PartyIntegrationClient {

    @PostMapping("/vendors/testing/e-kyc-result")
    void pushEKYCStatus(@RequestBody EKYCCallingResultDTO resultDTO);
}
