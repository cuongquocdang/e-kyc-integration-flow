package com.example.vendorservice.controllers;

import com.example.vendorservice.dtos.EKYCCallingResultDTO;
import com.example.vendorservice.dtos.EKYCDecisionRequestDTO;
import com.example.vendorservice.dtos.EKYCSearchingRequestDTO;
import com.example.vendorservice.services.EKYCService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/e-kyc-callings")
@RequiredArgsConstructor
public class EKYCController {

    private final EKYCService ekycService;

    @PostMapping("/decision")
    public void makeKYCDecision(@RequestBody EKYCDecisionRequestDTO requestDTO) {
        ekycService.makeKYCDecision(requestDTO);
    }

    @PostMapping("/call-log")
    public EKYCCallingResultDTO retrieveCallLog(@RequestBody EKYCSearchingRequestDTO requestDTO) {
        return ekycService.retrieveCallLog(requestDTO);
    }

}
