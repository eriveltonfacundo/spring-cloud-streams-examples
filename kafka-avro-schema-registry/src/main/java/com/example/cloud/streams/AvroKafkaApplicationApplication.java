package com.example.cloud.streams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

@EnableBinding(Processor.class)
@SpringBootApplication
@EnableSchemaRegistryClient
public class AvroKafkaApplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroKafkaApplicationApplication.class, args);
	}

}
