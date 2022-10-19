package com.example.cardmanagementsystem.dtos;

import com.example.cardmanagementsystem.dtos.enums.InternationalTransactionLimitationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardInfoDTO implements Serializable {

    private String contractIdentifier;
    private InternationalTransactionLimitationStatus transactionLimitationStatus;
}
