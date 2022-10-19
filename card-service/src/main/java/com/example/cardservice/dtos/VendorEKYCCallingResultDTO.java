package com.example.cardservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorEKYCCallingResultDTO {

    private String callingId;
    private String externalUserId;
    private String result;
}
