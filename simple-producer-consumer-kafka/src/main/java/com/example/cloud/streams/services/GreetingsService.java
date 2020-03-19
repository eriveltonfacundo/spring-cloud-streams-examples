package com.example.cloud.streams.services;

import com.example.cloud.streams.streams.GreetingsStreams;
import com.example.cloud.streams.models.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.messaging.MessageHeaders.CONTENT_TYPE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

@Slf4j
@Service
public class GreetingsService {

    @Autowired
    private GreetingsStreams greetingsStreams;

    public void sendGreeting(Greetings greetings) {
        log.info("Sending greetings {}", greetings);

        greetingsStreams.outboundGreetings()
                        .send(MessageBuilder
                        .withPayload(greetings)
                        .setHeader(CONTENT_TYPE, APPLICATION_JSON)
                        .build());
    }
}