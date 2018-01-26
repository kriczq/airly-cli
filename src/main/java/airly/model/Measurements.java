package airly.model;

import com.jsoniter.annotation.JsonProperty;

public class Measurements {
    @JsonProperty("airQualityIndex")
    private Double AirQualityIndex;
    @JsonProperty("humidity")
    private Double Humidity;
    @JsonProperty("measurementTime")
    private String MeasurementTime;
    @JsonProperty("pm1")
    private Double Pm1;
    @JsonProperty("pm10")
    private Double Pm10;
    @JsonProperty("pm25")
    private Double Pm25;
    @JsonProperty("pollutionLevel")
    private Double PollutionLevel;
    @JsonProperty("pressure")
    private Double Pressure;
    @JsonProperty("temperature")
    private Double Temperature;
    @JsonProperty("windDirection")
    private Double WindDirection;
    @JsonProperty("windSpeed")
    private Double WindSpeed;

    public Double getAirQualityIndex() {
        return AirQualityIndex;
    }

    public void setAirQualityIndex(Double airQualityIndex) {
        AirQualityIndex = airQualityIndex;
    }

    public Double getHumidity() {
        return Humidity;
    }

    public void setHumidity(Double humidity) {
        Humidity = humidity;
    }

    public String getMeasurementTime() {
        return MeasurementTime;
    }

    public void setMeasurementTime(String measurementTime) {
        MeasurementTime = measurementTime;
    }

    public Double getPm1() {
        return Pm1;
    }

    public void setPm1(Double pm1) {
        Pm1 = pm1;
    }

    public Double getPm10() {
        return Pm10;
    }

    public void setPm10(Double pm10) {
        Pm10 = pm10;
    }

    public Double getPm25() {
        return Pm25;
    }

    public void setPm25(Double pm25) {
        Pm25 = pm25;
    }

    public Double getPollutionLevel() {
        return PollutionLevel;
    }

    public void setPollutionLevel(Double pollutionLevel) {
        PollutionLevel = pollutionLevel;
    }

    public Double getPressure() {
        return Pressure;
    }

    public void setPressure(Double pressure) {
        Pressure = pressure;
    }

    public Double getTemperature() {
        return Temperature;
    }

    public void setTemperature(Double temperature) {
        Temperature = temperature;
    }

    public Double getWindDirection() {
        return WindDirection;
    }

    public void setWindDirection(Double windDirection) {
        WindDirection = windDirection;
    }

    public Double getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        WindSpeed = windSpeed;
    }

}
