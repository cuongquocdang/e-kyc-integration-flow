package com.example.cardservice.mappers;

import com.example.cardservice.dtos.CMSCardInfoDTO;
import com.example.cardservice.dtos.EKYCInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "eKYCResult", source = "transactionLimitationStatus")
    EKYCInfoDTO toEKYCInfo(CMSCardInfoDTO cardInfoDTO);
}
