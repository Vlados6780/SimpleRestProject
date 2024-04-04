package org.example.dto;

import java.util.List;

public class MeasurementResponse {
    private List<MeasurementDto> measurements;

    public List<MeasurementDto> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDto> measurements) {
        this.measurements = measurements;
    }
}
