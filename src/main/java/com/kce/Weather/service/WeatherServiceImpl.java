package com.kce.Weather.service;

import com.kce.Weather.dto.TemperatureSummaryDTO;
import com.kce.Weather.entity.Weather;
import com.kce.Weather.exception.ResourceNotFoundException;
import com.kce.Weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Weather getWeatherByDate(LocalDate date) {
        return repository.findByDate(date)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No data found for date: " + date));
    }

    @Override
    public List<Weather> getWeatherByMonth(int month) {
        return repository.findByMonth(month);
    }

    @Override
    public Map<String, TemperatureSummaryDTO> getYearSummary(int year) {

        List<Weather> list = repository.findByYear(year);

        Map<Integer, List<Double>> monthMap = new HashMap<>();

        for (Weather w : list) {
            int month = w.getDate().getMonthValue();
            monthMap.computeIfAbsent(month, k -> new ArrayList<>())
                    .add(w.getTemperature());
        }

        Map<String, TemperatureSummaryDTO> result = new LinkedHashMap<>();

        for (Integer month : monthMap.keySet()) {

            List<Double> temps = monthMap.get(month);
            Collections.sort(temps);

            double min = temps.get(0);
            double max = temps.get(temps.size() - 1);

            double median;
            int size = temps.size();

            if (size % 2 == 0) {
                median = (temps.get(size / 2 - 1) + temps.get(size / 2)) / 2;
            } else {
                median = temps.get(size / 2);
            }

            result.put(
                    Month.of(month).name(),
                    new TemperatureSummaryDTO(max, min, median)
            );
        }

        return result;
    }

	@Override
	public List<Weather> getAllWeather() {
		// TODO Auto-generated method stub
		return null;
	}
}