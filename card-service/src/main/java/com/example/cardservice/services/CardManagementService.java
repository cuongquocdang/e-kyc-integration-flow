package com.example.cardservice.services;

import com.example.cardservice.dtos.EKYCInfoDTO;

public interface CardManagementService {

    EKYCInfoDTO retrieveEKYCInfo(String contractIdentifier);
}
