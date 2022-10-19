package com.example.cardmanagementsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternationalTransactionLimitationChangedMessageDTO implements Serializable {

    private String internationalTransactionLimitationStatus;
}
