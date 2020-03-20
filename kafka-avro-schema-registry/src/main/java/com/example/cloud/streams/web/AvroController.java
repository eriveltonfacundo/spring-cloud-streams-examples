package com.example.cloud.streams.web;

import com.example.cloud.streams.producers.AvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;


@RestController
public class AvroController {

    @Autowired private AvroProducer avroProducer;

    @PostMapping("/employees/{id}/{firstName}/{lastName}")
    public String producerAvroMessage(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName) {
        avroProducer.produceEmployeeDetails(id, firstName, lastName);
        return "Sent employee details to consumer";
    }

}