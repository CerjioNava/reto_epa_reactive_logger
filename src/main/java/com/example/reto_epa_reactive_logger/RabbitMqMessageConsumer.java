package com.example.reto_epa_reactive_logger;

import com.example.reto_epa_reactive_logger.config.RabbitMQConfig;
import com.example.reto_epa_reactive_logger.mapper.RabbitErrorMapper;
import com.example.reto_epa_reactive_logger.mapper.RabbitLogMapper;
import com.example.reto_epa_reactive_logger.models.RabbitError;
import com.example.reto_epa_reactive_logger.models.RabbitLog;
import com.example.reto_epa_reactive_logger.models.dto.RabbitErrorDTO;
import com.example.reto_epa_reactive_logger.models.dto.RabbitLogDTO;
import com.example.reto_epa_reactive_logger.usecase.CreateRabbitErrorUseCase;
import com.example.reto_epa_reactive_logger.usecase.CreateRabbitLogUseCase;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

@Component
public class RabbitMqMessageConsumer implements CommandLineRunner {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Gson gson;

    @Autowired
    private CreateRabbitErrorUseCase createRabbitErrorUseCase;

    @Autowired
    private CreateRabbitLogUseCase createRabbitLogUseCase;

    @Override
    public void run(String... args) throws Exception {

        receiver.consumeAutoAck(RabbitMQConfig.QUEUE_NAME_ERROR)
                .map(message -> {
                    RabbitErrorDTO dto = gson
                            .fromJson(new String(message.getBody()),
                                    RabbitErrorDTO.class);

                    // Crear log de error en mongo
                    createRabbitErrorUseCase.accept(dto);

                    return dto;
                }).subscribe();

        receiver.consumeAutoAck(RabbitMQConfig.QUEUE_CLOUDWATCH)
                .map(message -> {
                    RabbitLogDTO dto = gson
                            .fromJson(new String(message.getBody()),
                                    RabbitLogDTO.class);

                    // Crear log estandar en mongo
                    createRabbitLogUseCase.accept(dto);

                    return dto;
                }).subscribe();
    }
}
