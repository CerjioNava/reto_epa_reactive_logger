package com.example.reto_epa_reactive_logger.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("RabbitError")
@Data
public class RabbitError {

    @Id
    private String id;
    private String statusCode;
    private String error;
    private Date date;

}
