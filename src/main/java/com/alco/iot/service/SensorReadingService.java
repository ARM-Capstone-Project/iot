package com.alco.iot.service;

import com.alco.iot.model.SensorReading;
import com.alco.iot.repository.SensorReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorReadingService {

    private final SensorReadingRepository repository;

    @Autowired
    public SensorReadingService(SensorReadingRepository repository) {
        this.repository = repository;
    }

    // Create (Save)
    public SensorReading save(SensorReading reading) {
        // You might add validation logic here before saving
        return repository.save(reading);
    }

    // Read (Get)
    public SensorReading findById(String id) {
        return repository.findById(id).orElse(null); // Or throw an exception if not found
    }

    public List<SensorReading> findAll() {
        return (List<SensorReading>) repository.findAll();
    }

    // Update (Put)
    public SensorReading update(SensorReading reading) {
        if (repository.existsById(reading.getId())) {
            return repository.save(reading);
        } else {
            throw new RuntimeException("Sensor reading not found for update"); // Or handle differently
        }
    }

    // Delete (Delete)
    public void deleteById(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Sensor reading not found for delete"); // Or handle differently
        }
    }
}
