package com.has.echostream.backend.services.device;

import com.has.echostream.backend.models.device.DataPoint;
import com.has.echostream.backend.repos.device.DataPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataPointService {

    private final DataPointRepository dataPointRepository;

    public DataPointService(DataPointRepository dataPointRepository) {
        this.dataPointRepository = dataPointRepository;
    }

    public List<DataPoint> getDataPointsByType(String type) {
        return dataPointRepository.findByType(type);
    }

    public DataPoint saveDataPoint(DataPoint dataPoint) {
        return dataPointRepository.save(dataPoint);
    }
}

