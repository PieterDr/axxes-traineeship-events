package com.axxes.traineeship.eventing.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AmqpApplication {

    /*
     * Configure Spring beans to create your own exchange, queue and binding.
     * You'll need the TopicExchange, Queue, Binding and BindingBuilder classes provided by spring-amqp
     *
     * Publish messages to your exchange using the RabbitTemplate bean.
     * You can use GenericEvent or define your own message.
     *
     * Also provide a @RabbitListener bean to consume the events published on your queue.
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AmqpApplication.class, args);
        RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);
    }
}
