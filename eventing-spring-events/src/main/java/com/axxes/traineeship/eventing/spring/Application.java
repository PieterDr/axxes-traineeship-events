package com.axxes.traineeship.eventing.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class Application {

    /*
     * Build an event-driven service, which could serve as the backend for the Traineeship project
     *
     * This service should have following features:
     *  - The audience can submit questions during a specific talk on which other audience members can vote
     *  - The speaker can initiate a poll in which the audience can partake
     *
     * Hints:
     *  - For publishing events -> use the ApplicationEventPublisher bean provided by Spring
     *  - For consuming events -> use the @EventListener annotation, e.g.
     *
     *        @EventListener
     *        public void consume(SomeEvent event) { ... }
     *
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        Api api = ctx.getBean(Api.class);
    }

    @Component
    static class Api {

        private final ApplicationEventPublisher eventPublisher;

        @Autowired
        Api(ApplicationEventPublisher eventPublisher) {
            this.eventPublisher = eventPublisher;
        }

        public void submitQuestion(int talkId, String question) {

        }

        public void voteOnQuestion(int talkId, int questionId) {

        }

        public void submitPoll(String question, List<String> answers) {

        }

        public void answerPoll(int pollId, int answer) {

        }

    }

}
