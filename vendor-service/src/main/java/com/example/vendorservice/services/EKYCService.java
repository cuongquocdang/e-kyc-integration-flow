package com.example.vendorservice.services;

import com.example.vendorservice.dtos.EKYCCallingResultDTO;
import com.example.vendorservice.dtos.EKYCDecisionRequestDTO;
import com.example.vendorservice.dtos.EKYCSearchingRequestDTO;

public interface EKYCService {

    void makeKYCDecision(EKYCDecisionRequestDTO requestDTO);

    EKYCCallingResultDTO retrieveCallLog(EKYCSearchingRequestDTO requestDTO);
}
