package com.kce.Weather.controller;

import com.kce.Weather.dto.TemperatureSummaryDTO;
import com.kce.Weather.entity.Weather;
import com.kce.Weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    
    @GetMapping("/")
    public String home() {
        return "Weather API is running successfully!";
    }
    @GetMapping("/month/{month}")
    public List<Weather> getByMonth(@PathVariable int month) {
        return service.getWeatherByMonth(month);
    }
    @GetMapping("/year/{year}/summary")
    public Map<String, TemperatureSummaryDTO> getYearSummary(@PathVariable int year) {
        return service.getYearSummary(year);
    }
}