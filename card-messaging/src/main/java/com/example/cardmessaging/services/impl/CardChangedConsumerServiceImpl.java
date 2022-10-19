package com.example.cardmessaging.services.impl;

import com.example.cardmessaging.services.CardChangedConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class CardChangedConsumerServiceImpl implements CardChangedConsumerService {

    @Override
    @RabbitListener(
            containerFactory = "connectionFactory",
            queues = "${card-changed-notification.internationalTransactionLimitationChanged.queue}")
    public void consumeInternationalTransactionLimitationChangedMessage(Message message) {
        log.info("RabbitMQ - received international transaction limitation changed message: {} and message properties: {}",
                new String(message.getBody(), StandardCharsets.UTF_8), message.getMessageProperties());
    }
}
