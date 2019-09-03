package com.axxes.traineeship.eventing.spring.checkin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckIn {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");

    private Date date;
    private String consultant;
    private String content;

    public CheckIn(String consultant, String content) {
        this.date = new Date();
        this.consultant = consultant;
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public String getConsultant() {
        return consultant;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "{" +
                "date: " + sdf.format(date) +
                ", consultant: '" + consultant + '\'' +
                ", content: '" + content + '\'' +
                '}';
    }
}
