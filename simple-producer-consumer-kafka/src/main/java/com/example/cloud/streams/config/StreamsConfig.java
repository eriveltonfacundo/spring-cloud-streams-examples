package com.example.cloud.streams.config;

import com.example.cloud.streams.streams.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}

