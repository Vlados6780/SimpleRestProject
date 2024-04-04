package rest.api.demo.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementErrorResponse {

    private String message;
    private long timestamp;

    public MeasurementErrorResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }


}
