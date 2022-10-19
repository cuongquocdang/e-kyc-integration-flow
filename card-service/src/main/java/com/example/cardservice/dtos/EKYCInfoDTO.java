package com.example.cardservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EKYCInfoDTO {

    private String contractIdentifier;
    private String eKYCResult;
}
