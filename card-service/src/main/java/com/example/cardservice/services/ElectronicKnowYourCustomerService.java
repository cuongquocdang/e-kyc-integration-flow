package com.example.cardservice.services;

import com.example.cardservice.dtos.VendorEKYCInfoRequestDTO;

public interface ElectronicKnowYourCustomerService {

    void handleStatusFromVendor(String vendor, VendorEKYCInfoRequestDTO requestDTO);
}
