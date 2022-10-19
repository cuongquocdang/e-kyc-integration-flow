package com.example.cardmanagementsystem.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "card-changed-notification")
@Data
public class CardNotificationRabbitProperties {

    private String notificationExchange;

    private QueueConfigInfo internationalTransactionLimitationChanged;

    @Data
    public static class QueueConfigInfo {

        private String key;
    }
}
