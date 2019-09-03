package com.axxes.traineeship.eventing.spring.consultant;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class ConsultantService {

    private List<Consultant> consultants;

    public ConsultantService(List<Consultant> consultants) {
        this.consultants = asList(
                //TODO add some consultants
        );
    }
}
