package com.has.backend.echostream.repos;

import com.has.backend.echostream.models.AnomalyReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnomalyReportRepository extends JpaRepository<AnomalyReport, Long> {
    List<AnomalyReport> findByDeviceId(Long deviceId);
    List<AnomalyReport> findByResolved(Boolean resolved);
}
