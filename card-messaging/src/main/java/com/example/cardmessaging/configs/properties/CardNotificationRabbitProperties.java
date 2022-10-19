package com.example.cardmessaging.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "card-changed-notification")
@Data
public class CardNotificationRabbitProperties {

    private int messageTimeToLive;
    private int maxDeadThreshold;

    private String notificationExchange;
    private String technicalDeadLetterExchange;

    private QueueConfigInfo internationalTransactionLimitationChanged;

    @Data
    public static class QueueConfigInfo {

        private String queue;
        private String deadLetterQueue;
        private String parkingLotQueue;
        private String key;
    }
}
