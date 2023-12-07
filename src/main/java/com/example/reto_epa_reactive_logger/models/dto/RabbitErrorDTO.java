package com.example.reto_epa_reactive_logger.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RabbitErrorDTO {

    private String id;
    private String statusCode;
    private String error;
    private Date date;

}
