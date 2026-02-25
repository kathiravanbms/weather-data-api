package com.kce.Weather.util;

import com.kce.Weather.entity.Weather;
import com.kce.Weather.repository.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CsvLoader implements CommandLineRunner {

    private final WeatherRepository repository;

    public CsvLoader(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/testset.csv"))
        );

        String line;
        boolean firstLine = true;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        while ((line = reader.readLine()) != null) {

           
            if (firstLine) {
                firstLine = false;
                continue;
            }

            
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] data = line.split(",");

           
            if (data.length < 4) {
                continue;
            }

            try {

               
                String rawDate = data[0].substring(0, 8);

                LocalDate date = LocalDate.parse(rawDate, formatter);

               
                if (data[2].trim().isEmpty() || data[3].trim().isEmpty()) {
                    continue;
                }

                double temperature = Double.parseDouble(data[2].trim());
                double humidity = Double.parseDouble(data[3].trim());

                Weather weather = new Weather();
                weather.setDate(date);
                weather.setTemperature(temperature);
                weather.setHumidity(humidity);

                repository.save(weather);

            } catch (Exception e) {
               
                continue;
            }
        }

        System.out.println("CSV Data Loaded Successfully!");
    }
}