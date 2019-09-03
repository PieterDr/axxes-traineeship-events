package com.axxes.traineeship.eventing.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AmqpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AmqpApplication.class, args);
        //TODO publish events to your exchange using the RabbitTemplate bean (you can use GenericEvent class, or make your own)
        //TODO configure a @RabbitListener to consume events from a queue
    }
}
