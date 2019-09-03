package com.axxes.traineeship.eventing.spring.checkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CheckInRestAPI {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void submitCheckIn(CheckIn checkIn) {
        eventPublisher.publishEvent(new CheckInSubmitted(checkIn));
    }
}
