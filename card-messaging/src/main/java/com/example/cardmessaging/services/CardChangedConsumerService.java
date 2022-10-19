package com.example.cardmessaging.services;

import org.springframework.amqp.core.Message;

public interface CardChangedConsumerService {

    @SuppressWarnings("unused")
    void consumeInternationalTransactionLimitationChangedMessage(Message message);
}
