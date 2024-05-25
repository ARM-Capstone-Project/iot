package com.alco.iot.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.alco.iot.model.SensorReading;

public interface SensorReadingRepository extends ElasticsearchRepository<SensorReading, String> {
    // ... Add custom query methods here if needed
}
