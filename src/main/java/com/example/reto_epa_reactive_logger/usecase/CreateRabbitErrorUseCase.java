package com.example.reto_epa_reactive_logger.usecase;

import com.example.reto_epa_reactive_logger.drivenAdapter.repository.IRabbitErrorRepository;
import com.example.reto_epa_reactive_logger.mapper.RabbitErrorMapper;
import com.example.reto_epa_reactive_logger.models.dto.RabbitErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.function.Consumer;

@Service
@Validated
public class CreateRabbitErrorUseCase implements Consumer<RabbitErrorDTO> {

    @Autowired
    private IRabbitErrorRepository iRabbitErrorRepository;

    @Autowired
    private RabbitErrorMapper rabbitErrorMapper;

    @Override
    public void accept(RabbitErrorDTO dto) {
        System.out.println("FAILED: "+dto.getDate()+" | "+" | "+dto.getStatusCode()+" | "+dto.getError());
        iRabbitErrorRepository.save(rabbitErrorMapper.fromDTOtoRabbitErrorEntity().apply(dto)).subscribe();
    }
}
