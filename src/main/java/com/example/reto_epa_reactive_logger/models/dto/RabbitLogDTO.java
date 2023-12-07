package com.example.reto_epa_reactive_logger.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RabbitLogDTO {

    private String id;
    private String message;
    private Date date;

}
