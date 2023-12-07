package com.example.reto_epa_reactive_logger.drivenAdapter.repository;

import com.example.reto_epa_reactive_logger.models.RabbitLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRabbitLogRepository extends ReactiveMongoRepository<RabbitLog, String> {
}
