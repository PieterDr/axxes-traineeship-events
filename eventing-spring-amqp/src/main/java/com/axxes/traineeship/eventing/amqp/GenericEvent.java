package com.axxes.traineeship.eventing.amqp;

import java.util.Date;

public class GenericEvent {

    private String event = "GENERIC_EVENT";
    private Date timestamp = new Date();

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
