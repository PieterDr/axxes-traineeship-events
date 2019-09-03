package com.axxes.traineeship.eventing.spring.checkin;

import com.axxes.traineeship.eventing.spring.consultant.Consultant;

public class CheckInDue {

    private Consultant consultant;

    public CheckInDue(Consultant consultant) {
        this.consultant = consultant;
    }

    public Consultant getConsultant() {
        return consultant;
    }
}
