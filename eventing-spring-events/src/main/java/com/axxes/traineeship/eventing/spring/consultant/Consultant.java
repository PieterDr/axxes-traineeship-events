package com.axxes.traineeship.eventing.spring.consultant;

public class Consultant {

    private String name;
    private String coach;

    public Consultant(String name, String coach) {
        this.name = name;
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }
}
