package com.kce.Weather.dto;

public class TemperatureSummaryDTO {

    private double max;
    private double min;
    private double median;

    public TemperatureSummaryDTO(double max, double min, double median) {
        this.max = max;
        this.min = min;
        this.median = median;
    }

    public double getMax() { return max; }
    public double getMin() { return min; }
    public double getMedian() { return median; }
}