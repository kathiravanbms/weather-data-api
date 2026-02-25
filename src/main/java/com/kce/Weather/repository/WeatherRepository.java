package com.kce.Weather.repository;

import com.kce.Weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findByDate(LocalDate date);

    @Query("SELECT w FROM Weather w WHERE MONTH(w.date) = :month")
    List<Weather> findByMonth(int month);

    @Query("SELECT w FROM Weather w WHERE YEAR(w.date) = :year")
    List<Weather> findByYear(int year);
}