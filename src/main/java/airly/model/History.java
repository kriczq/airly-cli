package airly.model;

import com.jsoniter.annotation.JsonProperty;

public class History {
    @JsonProperty("fromDateTime")
    private String FromDateTime;
    @JsonProperty("measurements")
    private airly.model.Measurements Measurements;
    @JsonProperty("tillDateTime")
    private String TillDateTime;

    public String getFromDateTime() {
        return FromDateTime;
    }

    public void setFromDateTime(String fromDateTime) {
        FromDateTime = fromDateTime;
    }

    public airly.model.Measurements getMeasurements() {
        return Measurements;
    }

    public void setMeasurements(airly.model.Measurements measurements) {
        Measurements = measurements;
    }

    public String getTillDateTime() {
        return TillDateTime;
    }

    public void setTillDateTime(String tillDateTime) {
        TillDateTime = tillDateTime;
    }

}
