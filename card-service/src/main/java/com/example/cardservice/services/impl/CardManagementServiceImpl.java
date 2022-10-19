package com.example.cardservice.services.impl;

import com.example.cardservice.clients.CardManagementSystemClient;
import com.example.cardservice.dtos.EKYCInfoDTO;
import com.example.cardservice.mappers.CardMapper;
import com.example.cardservice.services.CardManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardManagementServiceImpl implements CardManagementService {

    private final CardManagementSystemClient cardManagementSystem;
    private final CardMapper cardMapper;

    @Override
    public EKYCInfoDTO retrieveEKYCInfo(String contractIdentifier) {
        var cmsCardInfo =
                cardManagementSystem.retrieveCardInfoByContractIdentifier(contractIdentifier);
        return cardMapper.toEKYCInfo(cmsCardInfo);
    }
}
