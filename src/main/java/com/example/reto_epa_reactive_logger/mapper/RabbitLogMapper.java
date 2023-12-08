package com.example.reto_epa_reactive_logger.mapper;

import com.example.reto_epa_reactive_logger.models.RabbitLog;
import com.example.reto_epa_reactive_logger.models.dto.RabbitLogDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RabbitLogMapper {

        public Function<RabbitLogDTO, RabbitLog> fromDTOtoRabbitLogEntity() {
            return dto -> {
                RabbitLog rabbitLog = new RabbitLog();
                rabbitLog.setMessage(dto.getMessage());
                rabbitLog.setDate(dto.getDate());
                return rabbitLog;
            };
        }

        public Function<RabbitLog, RabbitLogDTO> fromRabbitLogEntityToDTO() {
            return rabbitLog -> {
                RabbitLogDTO dto = new RabbitLogDTO();
                dto.setId(rabbitLog.getId());
                dto.setMessage(rabbitLog.getMessage());
                dto.setDate(rabbitLog.getDate());
                return dto;
            };
        }
}
