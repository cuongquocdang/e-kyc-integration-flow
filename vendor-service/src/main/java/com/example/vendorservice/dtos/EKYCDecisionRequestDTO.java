package com.example.vendorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EKYCDecisionRequestDTO {

    private int result;

    private String callingId;

    private PartyIntegrationMetaDataDTO metaData;
}
