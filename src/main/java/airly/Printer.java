package airly;

import airly.model.Response;

public class Printer {
    private final Response response;

    public Printer(Response response) {
        this.response = response;
    }

    public void printCurrent() {
        StringBuilder output = new StringBuilder();

        output.append("CAQI: ");
        if (response.getCurrentMeasurements().getAirQualityIndex() < 50) {
            output.append("\u001B[32m");
        } else if (response.getCurrentMeasurements().getAirQualityIndex() < 90) {
            output.append("\u001B[33m");
        } else {
            output.append("\u001B[31m");
        }



        output.append(String.format("%.0f", response.getCurrentMeasurements().getAirQualityIndex()));

        if (response.getCurrentMeasurements().getAirQualityIndex() >= 90)
            output.append("\nStay today at home");

        output.append("\u001B[0m\n\n");

        output.append("PM 2.5: ");
        output.append(String.format("%.2f", response.getCurrentMeasurements().getPm25()));
        output.append(" μg/m3\n");

        output.append("PM 10: ");
        output.append(String.format("%.2f", response.getCurrentMeasurements().getPm10()));
        output.append(" μg/m3\n");

        output.append("Temperature: ");
        output.append(String.format("%.2f", response.getCurrentMeasurements().getTemperature()));
        output.append(" °C\n");

        output.append("Pressure: ");
        output.append(String.format("%.0f", response.getCurrentMeasurements().getPressure() / 100));
        output.append(" hPa\n");

        output.append("Humidity: ");
        output.append(String.format("%.0f", response.getCurrentMeasurements().getHumidity()));
        output.append(" %");

        System.out.println(output);
    }

    public void printHistory() {
        StringBuilder output = new StringBuilder();

        response.getHistory().forEach(x -> {
            output.append(x.getFromDateTime().substring(11, 16));
            output.append(" - ");
            output.append(x.getTillDateTime().substring(11, 16));
            output.append("\nPM 2.5: ");
            output.append(String.format("%.2f", x.getMeasurements().getPm25()));
            output.append(" μg/m3\n");

            output.append("PM 10: ");
            output.append(String.format("%.2f", x.getMeasurements().getPm10()));
            output.append(" μg/m3\n\n");
        });

        System.out.println(output);
    }
}
