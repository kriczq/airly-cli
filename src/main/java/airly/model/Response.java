package airly.model;

import java.util.List;
import com.jsoniter.annotation.JsonProperty;

public class Response {
    @JsonProperty("currentMeasurements")
    private Measurements CurrentMeasurements;
    @JsonProperty("forecast")
    private List<airly.model.Forecast> Forecast;
    @JsonProperty("history")
    private List<airly.model.History> History;

    public Measurements getCurrentMeasurements() {
        return CurrentMeasurements;
    }

    public void setCurrentMeasurements(Measurements currentMeasurements) {
        CurrentMeasurements = currentMeasurements;
    }

    public List<airly.model.Forecast> getForecast() {
        return Forecast;
    }

    public void setForecast(List<airly.model.Forecast> forecast) {
        Forecast = forecast;
    }

    public List<airly.model.History> getHistory() {
        return History;
    }

    public void setHistory(List<airly.model.History> history) {
        History = history;
    }

}
