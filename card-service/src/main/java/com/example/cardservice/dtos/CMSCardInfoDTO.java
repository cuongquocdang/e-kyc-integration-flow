package com.example.cardservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CMSCardInfoDTO {

    private String contractIdentifier;
    private String transactionLimitationStatus;
}
