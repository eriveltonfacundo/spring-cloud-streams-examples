package com.example.springcloudstreamsexamples.web;

import com.example.springcloudstreamsexamples.models.Greetings;
import com.example.springcloudstreamsexamples.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.currentTimeMillis;
import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
public class GreetingsController {

    @Autowired private GreetingsService greetingsService;

    @GetMapping("/greetings")
    @ResponseStatus(ACCEPTED)
    public void greetings(@RequestParam("message") String message) {
        Greetings greetings = Greetings.builder()
                .message(message)
                .timestamp(currentTimeMillis())
                .build();

        greetingsService.sendGreeting(greetings);
    }
}
