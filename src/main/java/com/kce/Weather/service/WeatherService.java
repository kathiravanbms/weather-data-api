package com.kce.Weather.service;

import com.kce.Weather.dto.TemperatureSummaryDTO;
import com.kce.Weather.entity.Weather;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface WeatherService {

    Weather getWeatherByDate(LocalDate date);

    List<Weather> getWeatherByMonth(int month);

    Map<String, TemperatureSummaryDTO> getYearSummary(int year);

	List<Weather> getAllWeather();
}