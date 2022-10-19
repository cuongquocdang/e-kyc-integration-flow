package com.example.cardmanagementsystem.services.impl;

import com.example.cardmanagementsystem.dtos.InternationalTransactionLimitationChangedMessageDTO;
import com.example.cardmanagementsystem.dtos.enums.InternationalTransactionLimitationStatus;
import com.example.cardmanagementsystem.services.CardNotificationService;
import com.example.cardmanagementsystem.services.InternationalTransactionLimitationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InternationalTransactionLimitationServiceImpl implements InternationalTransactionLimitationService {

    private final CardNotificationService cardNotificationService;

    public void unblockInternationalTransactionLimitation() {
        var message = InternationalTransactionLimitationChangedMessageDTO.builder()
                .internationalTransactionLimitationStatus(InternationalTransactionLimitationStatus.UNBLOCKED.name())
                .build();
        cardNotificationService.publishInternationalTransactionLimitationChangedMessage(message);
    }

    public void blockInternationalTransactionLimitation() {
        var message = InternationalTransactionLimitationChangedMessageDTO.builder()
                .internationalTransactionLimitationStatus(InternationalTransactionLimitationStatus.BLOCKED.name())
                .build();
        cardNotificationService.publishInternationalTransactionLimitationChangedMessage(message);
    }

}
