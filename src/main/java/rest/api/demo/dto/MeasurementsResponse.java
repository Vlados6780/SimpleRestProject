package rest.api.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MeasurementsResponse {

    @Getter
    @Setter
    private List<MeasurementDTO> measurements;

    public MeasurementsResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
