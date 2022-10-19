package com.example.cardmanagementsystem.services.impl;

import com.example.cardmanagementsystem.configs.properties.CardNotificationRabbitProperties;
import com.example.cardmanagementsystem.dtos.InternationalTransactionLimitationChangedMessageDTO;
import com.example.cardmanagementsystem.dtos.enums.NotificationResult;
import com.example.cardmanagementsystem.services.CardNotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardNotificationServiceImpl implements CardNotificationService {

    private final RabbitTemplate rabbitTemplate;
    private final CardNotificationRabbitProperties rabbitProperties;
    private final ObjectMapper objectMapper;

    @Override
    public NotificationResult publishInternationalTransactionLimitationChangedMessage(InternationalTransactionLimitationChangedMessageDTO messageDTO) {
        try {
            var messageConverted = new Message(objectMapper.writeValueAsBytes(messageDTO));
            log.info("RabbitMQ - processing to send international transaction limitation changed message: {} and message properties: {}",
                    new String(messageConverted.getBody(), StandardCharsets.UTF_8), messageConverted.getMessageProperties());
            rabbitTemplate.send(
                    rabbitProperties.getNotificationExchange(),
                    rabbitProperties.getInternationalTransactionLimitationChanged().getKey(),
                    messageConverted);
            return NotificationResult.SUCCESS;
        } catch (JsonProcessingException exception) {
            log.error("RabbitMQ - an error occurs when sending international transaction limitation changed message: {}", exception.getMessage());
            return NotificationResult.FAILURE;
        }
    }
}
