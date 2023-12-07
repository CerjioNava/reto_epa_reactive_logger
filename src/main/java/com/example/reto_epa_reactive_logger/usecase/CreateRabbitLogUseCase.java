package com.example.reto_epa_reactive_logger.usecase;

import com.example.reto_epa_reactive_logger.drivenAdapter.repository.IRabbitLogRepository;
import com.example.reto_epa_reactive_logger.mapper.RabbitLogMapper;
import com.example.reto_epa_reactive_logger.models.dto.RabbitLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.function.Consumer;

@Service
@Validated
public class CreateRabbitLogUseCase implements Consumer<RabbitLogDTO> {

    @Autowired
    private IRabbitLogRepository iRabbitLogRepository;

    @Autowired
    private RabbitLogMapper rabbitLogMapper;

    @Override
    public void accept(RabbitLogDTO dto) {
        System.out.println("INFO: " + dto);
        iRabbitLogRepository.save(rabbitLogMapper.fromDTOtoRabbitLogEntity().apply(dto));
    }
}
