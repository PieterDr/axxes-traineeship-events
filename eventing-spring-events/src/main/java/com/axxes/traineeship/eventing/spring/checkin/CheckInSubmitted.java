package com.axxes.traineeship.eventing.spring.checkin;

public class CheckInSubmitted {

    private CheckIn checkIn;

    public CheckInSubmitted(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }
}
