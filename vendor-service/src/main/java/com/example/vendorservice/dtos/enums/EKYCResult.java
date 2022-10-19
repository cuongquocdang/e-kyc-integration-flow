package com.example.vendorservice.dtos.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public enum EKYCResult {
    APPROVED(1),
    REJECTED(-1),
    UNDECIDED(0);

    private final int codeDefinition;

    private static final Map<Integer, EKYCResult> ekycResults;

    static {
        ekycResults = new HashMap<>();
        for (EKYCResult ekycResult : EKYCResult.values()) {
            ekycResults.put(ekycResult.getCodeDefinition(), ekycResult);
        }
    }

    public static EKYCResult findByCodeDefinition(int codeDefinition) {
        return Optional.ofNullable(ekycResults.get(codeDefinition))
                .orElseThrow(() -> new IllegalArgumentException("Could not found any mapped result by " + codeDefinition));
    }
}
