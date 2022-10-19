package com.example.cardservice.controllers;

import com.example.cardservice.dtos.VendorEKYCInfoRequestDTO;
import com.example.cardservice.services.ElectronicKnowYourCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/electronic-know-your-customers")
@RequiredArgsConstructor
public class ElectronicKnowYourCustomerController {

    private final ElectronicKnowYourCustomerService electronicKnowYourCustomerService;

    @PostMapping("/vendors/{vendor}/transaction-limitations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleStatusFromVendor(@PathVariable String vendor, VendorEKYCInfoRequestDTO requestDTO) {
        electronicKnowYourCustomerService.handleStatusFromVendor(vendor, requestDTO);
    }

}
