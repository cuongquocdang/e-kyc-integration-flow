package com.example.cardservice.services;

import com.example.cardservice.dtos.VendorEKYCCallingResultDTO;

public interface ElectronicKnowYourCustomerService {

    void handleStatusFromVendor(String vendor, VendorEKYCCallingResultDTO resultDTO);
}
