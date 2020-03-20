package com.example.cloud.streams.producers;

import com.example.cloud.streams.schema.Employee;
import com.example.cloud.streams.schema.EmployeeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;
import static org.springframework.kafka.support.KafkaHeaders.MESSAGE_KEY;
import static org.springframework.messaging.support.MessageBuilder.withPayload;

@Service
public class AvroProducer {

    @Autowired private Processor processor;

    public void produceEmployeeDetails(Long empId, String firstName, String lastName) {

        // creating employee details
        Employee employee = new Employee();
        employee.setId(empId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDepartment("IT");
        employee.setDesignation("Engineer");

        // creating partition key for kafka topic
        EmployeeKey employeeKey = new EmployeeKey();
        employeeKey.setId(empId);
        employeeKey.setDepartmentName("IT");

        Message<Employee> message = withPayload(employee)
                .setHeader(MESSAGE_KEY, employeeKey)
                .build();

        processor.output()
                .send(message);
    }

}
