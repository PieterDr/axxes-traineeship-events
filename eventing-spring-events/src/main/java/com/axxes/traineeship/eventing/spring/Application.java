package com.axxes.traineeship.eventing.spring;

import com.axxes.traineeship.eventing.spring.checkin.CheckIn;
import com.axxes.traineeship.eventing.spring.checkin.CheckInRestAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        // We're going to build an event-driven service, which could serve as the back-end for the project case
        // This service should have following features:
        //  - A REST API allowing consultants to submit check-ins
        //  - For each submitted check-in, the consultant and coach are notified by mail
        //  - Sending out reminders to consultants to submit their quarterly check-in.
        // Hints:
        //  - For publishing events -> use the ApplicationEventPublisher bean provided by Spring
        //  - For consuming events -> use the @EventListener annotation, e.g.
        //      @EventListener
        //      public void consume(SomeEvent event) {}
        CheckInRestAPI api = ctx.getBean("checkInRestAPI", CheckInRestAPI.class);
        api.submitCheckIn(new CheckIn("Pieter Drijkoningen", "Alles in orde!"));
    }

}
