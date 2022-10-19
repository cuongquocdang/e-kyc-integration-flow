package com.example.cardmanagementsystem.services.impl;

import com.example.cardmanagementsystem.dtos.CardInfoDTO;
import com.example.cardmanagementsystem.dtos.enums.InternationalTransactionLimitationStatus;
import com.example.cardmanagementsystem.services.CardOperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CardOperatorServiceImpl implements CardOperatorService {

    @Override
    public CardInfoDTO retrieveCardInfoByContractIdentifier(String contractIdentifier) {
        log.info("Query: {} from database", contractIdentifier);
        return CardInfoDTO.builder()
                .contractIdentifier(contractIdentifier)
                .transactionLimitationStatus(InternationalTransactionLimitationStatus.UNBLOCKED)
                .build();
    }
}
