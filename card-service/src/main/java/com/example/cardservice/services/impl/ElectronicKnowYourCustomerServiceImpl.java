package com.example.cardservice.services.impl;

import com.example.cardservice.clients.VendorEKYCClient;
import com.example.cardservice.dtos.VendorEKYCCallingResultDTO;
import com.example.cardservice.dtos.VendorEKYCSearchingRequestDTO;
import com.example.cardservice.services.ElectronicKnowYourCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElectronicKnowYourCustomerServiceImpl implements ElectronicKnowYourCustomerService {

    private final VendorEKYCClient vendorEKYCClient;

    @Override
    public void handleStatusFromVendor(String vendor, VendorEKYCCallingResultDTO requestDTO) {
        log.info("Receive e-kyc status: {} from vendor: {}", requestDTO, vendor);
        var callLogRequest = VendorEKYCSearchingRequestDTO.builder()
                .callingId(requestDTO.getCallingId())
                .externalUserId(requestDTO.getExternalUserId())
                .build();
        var callLogResponse = vendorEKYCClient.retrieveCallLog(callLogRequest);
        log.info("Receive call log: {} from vendor: {}", callLogResponse, vendor);
    }
}
