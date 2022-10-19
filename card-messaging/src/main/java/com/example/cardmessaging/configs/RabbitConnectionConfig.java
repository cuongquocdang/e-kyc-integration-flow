package com.example.cardmessaging.configs;

import com.example.cardmessaging.configs.properties.RabbitConnectionProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConnectionConfig {

    private final RabbitConnectionProperties rabbitConnectionProperties;

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return rabbitConnectionProperties.buildConnection();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory connectionFactory(
            CachingConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter messageConverter) {
        var factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        return factory;
    }

}
