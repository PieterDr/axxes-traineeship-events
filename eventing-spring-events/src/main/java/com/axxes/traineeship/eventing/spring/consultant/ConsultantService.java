package com.axxes.traineeship.eventing.spring.consultant;

import com.axxes.traineeship.eventing.spring.checkin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Component
public class ConsultantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantService.class);

    private ApplicationEventPublisher eventPublisher;
    private List<Consultant> consultants;

    @Autowired
    public ConsultantService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        this.consultants = asList(new Consultant("Pieter Drijkoningen", "Dylan Honorez"));
    }

    @EventListener
    public void checkInSubmitted(CheckInSubmitted event) {
        CheckIn checkIn = event.getCheckIn();
        findConsultant(checkIn.getConsultant())
                .ifPresent(consultant -> {
                    LOGGER.info("Storing check-in: {}", checkIn);
                    eventPublisher.publishEvent(new CheckInStored(checkIn, consultant));
                });
    }

    private Optional<Consultant> findConsultant(String consultant) {
        return consultants.stream().filter(c -> consultant.equals(c.getName())).findFirst();
    }

    @EventListener
    public void remindersDue(CheckInsDue event) {
        consultants.stream()
                .map(CheckInDue::new)
                .forEach(eventPublisher::publishEvent);
    }
}
