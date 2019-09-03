package com.axxes.traineeship.eventing.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AmqpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AmqpApplication.class, args);
        //TODO publish events to your exchange using the RabbitTemplate bean (you can use GenericEvent class, or make your own)
        //TODO configure a @RabbitListener to consume events from a queue
        RabbitTemplate rabbitTemplate = ctx.getBean("rabbitTemplate", RabbitTemplate.class);
        rabbitTemplate.convertAndSend("AXXES_EXCHANGE", "", new GenericEvent());
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(AmqpApplication.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "AXXES_QUEUE")
    public void consume(GenericEvent genericEvent) throws JsonProcessingException {
        LOGGER.info("CONSUMING EVENT: {}", objectMapper.writeValueAsString(genericEvent));
    }
}
