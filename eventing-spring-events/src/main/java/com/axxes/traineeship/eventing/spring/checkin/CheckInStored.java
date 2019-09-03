package com.axxes.traineeship.eventing.spring.checkin;

import com.axxes.traineeship.eventing.spring.consultant.Consultant;

public class CheckInStored {

    private CheckIn checkIn;
    private Consultant consultant;

    public CheckInStored(CheckIn checkIn, Consultant consultant) {
        this.checkIn = checkIn;
        this.consultant = consultant;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public Consultant getConsultant() {
        return consultant;
    }
}
