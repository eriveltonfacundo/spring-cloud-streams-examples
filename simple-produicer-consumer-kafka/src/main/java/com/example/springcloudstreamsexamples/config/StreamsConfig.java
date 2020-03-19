package com.example.springcloudstreamsexamples.config;

import com.example.springcloudstreamsexamples.streams.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}

