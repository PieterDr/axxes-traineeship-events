package com.axxes.traineeship.eventing.spring;

import com.axxes.traineeship.eventing.spring.checkin.CheckInsDue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Scheduled(cron = "0/5 * * * * *") // Every 5 seconds
    public void sendCheckInReminders() {
        //TODO implement
        eventPublisher.publishEvent(new CheckInsDue());
    }
}
