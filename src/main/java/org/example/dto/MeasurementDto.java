package org.example.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MeasurementDto {
    @NotNull(message = "Value should not be empty")
    @Min(value = -100, message = "Temperature should be higher than -100")
    @Max(value = 100, message = "Temperature should be lower than 100")
    private Double value;

    @NotNull(message = "Condition should not be empty")
    private Boolean raining;

    @NotNull(message = "Sensor should not be empty")
    private SensorDto sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDto getSensor() {
        return sensor;
    }

    public void setSensor(SensorDto sensor) {
        this.sensor = sensor;
    }
}
