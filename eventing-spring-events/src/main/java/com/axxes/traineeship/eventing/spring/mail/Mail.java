package com.axxes.traineeship.eventing.spring.mail;

public class Mail {

    private String from;
    private String to;
    private String subject;
    private String content;

    public Mail(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "from: '" + from + '\'' +
                ", to: '" + to + '\'' +
                ", subject: '" + subject + '\'' +
                ", content: '" + content + '\'' +
                '}';
    }
}
