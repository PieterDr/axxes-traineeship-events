package com.axxes.traineeship.eventing.spring.mail;

import com.axxes.traineeship.eventing.spring.checkin.CheckIn;
import com.axxes.traineeship.eventing.spring.checkin.CheckInDue;
import com.axxes.traineeship.eventing.spring.checkin.CheckInStored;
import com.axxes.traineeship.eventing.spring.consultant.Consultant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Mailer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Mailer.class);
    public static final String NO_REPLY = "noreply@axxes.com";

    @EventListener
    public void reminderDue(CheckInDue event) {
        sendNoReplyMail(event.getConsultant().getName(), "Check-in time...", "Het is tijd voor je check-in!");
    }

    @EventListener
    public void checkInStored(CheckInStored event) {
        Consultant consultant = event.getConsultant();
        CheckIn checkIn = event.getCheckIn();
        sendNoReplyMail(consultant.getName(), "Nieuwe check-in", "Check-in verwerkt: " + checkIn.toString());
        sendNoReplyMail(consultant.getCoach(), "Nieuwe check-in", "Check-in verwerkt: " + checkIn.toString());
    }

    private void sendNoReplyMail(String to, String subject, String content) {
        LOGGER.info("Sending mail: {}", new Mail(NO_REPLY, to, subject, content));
    }
}
