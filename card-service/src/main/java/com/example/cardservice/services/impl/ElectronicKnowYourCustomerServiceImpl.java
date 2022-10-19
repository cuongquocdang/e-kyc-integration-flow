package com.example.cardservice.services.impl;

import com.example.cardservice.dtos.VendorEKYCInfoRequestDTO;
import com.example.cardservice.services.ElectronicKnowYourCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ElectronicKnowYourCustomerServiceImpl implements ElectronicKnowYourCustomerService {

    @Override
    public void handleStatusFromVendor(String vendor, VendorEKYCInfoRequestDTO requestDTO) {
        log.info("Receive e-kyc status: {} from vendor: {}", requestDTO, vendor);
        log.info("Query vendor call log");
    }
}
