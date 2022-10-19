package com.example.vendorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartyIntegrationMetaDataDTO {

    private String customerId;
    private String customerName;
}
