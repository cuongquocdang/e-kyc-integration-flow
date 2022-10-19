package com.example.cardmanagementsystem.controllers;

import com.example.cardmanagementsystem.dtos.CardInfoDTO;
import com.example.cardmanagementsystem.services.CardOperatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/card-managements/card-operators")
@RequiredArgsConstructor
@Slf4j
public class CardOperatorController {

    private final CardOperatorService cardOperatorService;

    @GetMapping("/{contractIdentifier}/retrieve")
    public CardInfoDTO retrieveCardInfoByContractIdentifier(@PathVariable String contractIdentifier) {
        return cardOperatorService.retrieveCardInfoByContractIdentifier(contractIdentifier);
    }
}
