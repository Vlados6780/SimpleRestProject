package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SensorDto {

    @NotEmpty(message = "Sensor name cannot be empty")
    @Size(min = 3, max = 30, message = "Sensor name must be between 3 and 30 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
