package rest.api.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class SensorDTO {
    @NotEmpty(message = "Sensor name cannot be empty")
    @Size(min = 3, max = 30, message = "Sensor name must be between 3 and 30 characters")
    @Getter
    @Setter
    private String name;
}
