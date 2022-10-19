package com.example.cardservice.clients;

import com.example.cardservice.dtos.CMSCardInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cardManagementSystem", url = "http://localhost:8000/v1/card-managements")
public interface CardManagementSystemClient {

    @GetMapping("/card-operators/{contractIdentifier}/retrieve")
    CMSCardInfoDTO retrieveCardInfoByContractIdentifier(@PathVariable String contractIdentifier);
}
