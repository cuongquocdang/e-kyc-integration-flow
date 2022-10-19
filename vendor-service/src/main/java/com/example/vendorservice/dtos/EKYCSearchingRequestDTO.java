package com.example.vendorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EKYCSearchingRequestDTO {

    private String callingId;
    private String externalUserId;
}
