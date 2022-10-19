package com.example.vendorservice.services.impl;

import com.example.vendorservice.clients.PartyIntegrationClient;
import com.example.vendorservice.dtos.EKYCCallingResultDTO;
import com.example.vendorservice.dtos.EKYCDecisionRequestDTO;
import com.example.vendorservice.dtos.EKYCSearchingRequestDTO;
import com.example.vendorservice.dtos.enums.EKYCResult;
import com.example.vendorservice.mappers.EKYCMapper;
import com.example.vendorservice.services.EKYCService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EKYCServiceImpl implements EKYCService {

    private final PartyIntegrationClient partyIntegrationClient;
    private final EKYCMapper ekycMapper;

    @Override
    public void makeKYCDecision(EKYCDecisionRequestDTO requestDTO) {
        log.info("Store: {} to database", requestDTO);
        var ekycResult = ekycMapper.toCallingResult(requestDTO);
        partyIntegrationClient.pushEKYCStatus(ekycResult);
    }

    @Override
    public EKYCCallingResultDTO retrieveCallLog(EKYCSearchingRequestDTO requestDTO) {
        log.info("Query: {} from database", requestDTO);
        return EKYCCallingResultDTO.builder()
                .callingId(requestDTO.getCallingId())
                .externalUserId(requestDTO.getExternalUserId())
                .result(EKYCResult.APPROVED.name())
                .build();
    }
}
