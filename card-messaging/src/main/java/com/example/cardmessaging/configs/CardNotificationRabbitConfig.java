package com.example.cardmessaging.configs;

import com.example.cardmessaging.configs.properties.CardNotificationRabbitProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CardNotificationRabbitConfig {

    private final CardNotificationRabbitProperties cardNotificationRabbitProperties;

    @Bean
    public DirectExchange cardNotificationDirectExchange() {
        return new DirectExchange(cardNotificationRabbitProperties.getNotificationExchange());
    }

    @Bean
    public TopicExchange technicalTopicExchange() {
        return new TopicExchange(cardNotificationRabbitProperties.getTechnicalDeadLetterExchange());
    }

    @Bean
    public Queue internationalTransactionLimitationChangedQueue() {
        var queueInfo =
                cardNotificationRabbitProperties.getInternationalTransactionLimitationChanged();
        return QueueBuilder
                .durable(queueInfo.getQueue())
                .deadLetterExchange(cardNotificationRabbitProperties.getTechnicalDeadLetterExchange())
                .deadLetterRoutingKey(queueInfo.getDeadLetterQueue())
                .build();
    }

    @Bean
    public Queue internationalTransactionLimitationChangedDLQ() {
        var queueInfo =
                cardNotificationRabbitProperties.getInternationalTransactionLimitationChanged();
        return QueueBuilder
                .durable(queueInfo.getDeadLetterQueue())
                .deadLetterExchange(cardNotificationRabbitProperties.getTechnicalDeadLetterExchange())
                .deadLetterRoutingKey(queueInfo.getQueue())
                .ttl(cardNotificationRabbitProperties.getMessageTimeToLive())
                .build();
    }

    @Bean
    public Queue internationalTransactionLimitationChangedPLQ() {
        return QueueBuilder
                .durable(cardNotificationRabbitProperties.getInternationalTransactionLimitationChanged().getParkingLotQueue())
                .build();
    }

    @Bean
    public Binding internationalTransactionLimitationChangedBinding(Queue internationalTransactionLimitationChangedQueue,
                                                                    DirectExchange cardNotificationDirectExchange) {
        return BindingBuilder.bind(internationalTransactionLimitationChangedQueue)
                .to(cardNotificationDirectExchange)
                .with(cardNotificationRabbitProperties.getInternationalTransactionLimitationChanged().getKey());
    }

    @Bean
    public Declarables internationalTransactionLimitationChangedTechnicalBindings(Queue internationalTransactionLimitationChangedQueue,
                                                                                  Queue internationalTransactionLimitationChangedDLQ,
                                                                                  Queue internationalTransactionLimitationChangedPLQ,
                                                                                  TopicExchange technicalTopicExchange) {
        return new Declarables(
                BindingBuilder
                        .bind(internationalTransactionLimitationChangedQueue)
                        .to(technicalTopicExchange)
                        .with(internationalTransactionLimitationChangedQueue.getName()),
                BindingBuilder
                        .bind(internationalTransactionLimitationChangedDLQ)
                        .to(technicalTopicExchange)
                        .with(internationalTransactionLimitationChangedDLQ.getName()),
                BindingBuilder
                        .bind(internationalTransactionLimitationChangedPLQ)
                        .to(technicalTopicExchange)
                        .with(internationalTransactionLimitationChangedPLQ.getName()));
    }
}
