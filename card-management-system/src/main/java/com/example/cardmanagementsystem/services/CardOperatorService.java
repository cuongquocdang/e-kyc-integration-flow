package com.example.cardmanagementsystem.services;

import com.example.cardmanagementsystem.dtos.CardInfoDTO;

public interface CardOperatorService {

    CardInfoDTO retrieveCardInfoByContractIdentifier(String contractIdentifier);
}
