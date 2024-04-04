package rest.api.demo.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rest.api.demo.dto.SensorDTO;
import rest.api.demo.models.Sensor;
import rest.api.demo.services.SensorService;
import rest.api.demo.utils.MeasurementErrorResponse;
import rest.api.demo.utils.MeasurementException;
import rest.api.demo.utils.SensorValidator;

import static rest.api.demo.utils.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorService sensorService;
    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;

    @Autowired
    public SensorsController(SensorService sensorService,
                             ModelMapper modelMapper,
                             SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }

   @PostMapping("/registration")
   public ResponseEntity<HttpStatus> save(@RequestBody @Valid SensorDTO sensorDTO,
                                                  BindingResult bindingResult){

       Sensor sensorToAdd = convertToSensor(sensorDTO);

       sensorValidator.validate(sensorToAdd, bindingResult);

       if (bindingResult.hasErrors()) {
           returnErrorsToClient(bindingResult);
       }

        sensorService.save(sensorToAdd);

        return new ResponseEntity<>(HttpStatus.OK);
}

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
