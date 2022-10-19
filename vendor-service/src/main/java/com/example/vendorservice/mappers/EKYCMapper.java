package com.example.vendorservice.mappers;

import com.example.vendorservice.dtos.EKYCCallingResultDTO;
import com.example.vendorservice.dtos.EKYCDecisionRequestDTO;
import com.example.vendorservice.dtos.enums.EKYCResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EKYCMapper {

    @Mapping(target = "result", source = "requestDTO.result", qualifiedByName = "ekycResult")
    @Mapping(target = "externalUserId", source = "requestDTO.metaData.customerId")
    EKYCCallingResultDTO toCallingResult(EKYCDecisionRequestDTO requestDTO);

    @Named("ekycResult")
    default String toEKYCResult(int result) {
        return EKYCResult.findByCodeDefinition(result).name();
    }

}
