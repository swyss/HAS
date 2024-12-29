package com.has.backend.echostream.services.device;

import com.has.backend.echostream.models.device.DataPoint;
import com.has.backend.echostream.repos.device.DataPointRepository;
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

