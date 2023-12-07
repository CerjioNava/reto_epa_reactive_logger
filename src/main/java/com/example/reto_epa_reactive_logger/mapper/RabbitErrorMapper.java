package com.example.reto_epa_reactive_logger.mapper;

import com.example.reto_epa_reactive_logger.models.RabbitError;
import com.example.reto_epa_reactive_logger.models.dto.RabbitErrorDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RabbitErrorMapper {

    public Function<RabbitErrorDTO, RabbitError> fromDTOtoRabbitErrorEntity() {
        return dto -> {
            RabbitError rabbitError = new RabbitError();
            rabbitError.setStatusCode(dto.getStatusCode());
            rabbitError.setError(dto.getError());
            rabbitError.setDate(dto.getDate());
            return rabbitError;
        };
    }

    public Function<RabbitError, RabbitErrorDTO> fromRabbitErrorEntityToDTO() {
        return rabbitError -> {
            RabbitErrorDTO dto = new RabbitErrorDTO();
            dto.setId(rabbitError.getId());
            dto.setStatusCode(rabbitError.getStatusCode());
            dto.setError(rabbitError.getError());
            dto.setDate(rabbitError.getDate());
            return dto;
        };
    }
}
