package com.example.cardservice.controllers;

import com.example.cardservice.dtos.EKYCInfoDTO;
import com.example.cardservice.services.CardManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final CardManagementService cardManagementService;

    @GetMapping("/{contractIdentifier}/e-kyc-retrieve")
    public EKYCInfoDTO retrieveEKYCInfo(@PathVariable String contractIdentifier) {
        return cardManagementService.retrieveEKYCInfo(contractIdentifier);
    }
}
