package org.example;

import org.example.dto.MeasurementDto;
import org.example.dto.MeasurementResponse;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DrawChart {

    public static void main(String[] args) {

        List<Double> temperatures = getTemperaturesFromServer();
        drawChart(temperatures);
    }

    private static void drawChart(List<Double> temperatures) {
        double[] xData = IntStream.range(0, temperatures.size()).asDoubleStream().toArray();
        double[] yData = temperatures.stream().mapToDouble(x ->x).toArray();

        XYChart chart = QuickChart.getChart("Temperatures", "X", "Y",
                "temperature",
                           xData, yData);
        new SwingWrapper<>(chart).displayChart();
    }

    private static List<Double> getTemperaturesFromServer() {
        final RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/measurements";

        MeasurementResponse jsonResponse = restTemplate.getForObject(url, MeasurementResponse.class);
        if (jsonResponse == null || jsonResponse.getMeasurements() == null) {
            return Collections.emptyList();
        }

        return jsonResponse.getMeasurements().stream().map(MeasurementDto::getValue)
                .collect(Collectors.toList());

    }


}
