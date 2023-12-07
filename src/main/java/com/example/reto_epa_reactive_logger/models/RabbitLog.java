package com.example.reto_epa_reactive_logger.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("RabbitLog")
@Data
public class RabbitLog {

    @Id
    private String id;
    private String message;
    private Date date;

}
