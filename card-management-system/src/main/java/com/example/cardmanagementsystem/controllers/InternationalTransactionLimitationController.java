package com.example.cardmanagementsystem.controllers;

import com.example.cardmanagementsystem.services.InternationalTransactionLimitationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/card-managements/internation-transaction-limitations")
@RequiredArgsConstructor
@Slf4j
public class InternationalTransactionLimitationController {

    private final InternationalTransactionLimitationService internationalTransactionLimitationService;

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unblockInternationalTransactionLimitation() {
        internationalTransactionLimitationService.unblockInternationalTransactionLimitation();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void blockInternationalTransactionLimitation() {
        internationalTransactionLimitationService.blockInternationalTransactionLimitation();
    }

}
