package airly;

import airly.model.Response;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            CmdLineParser parser = new CmdLineParser(args);

            String apiKey = null;

            if (System.getenv().containsKey("API_KEY"))
                apiKey = System.getenv().get("API_KEY");

            if (parser.getOption("api-key").isPresent())
                apiKey = parser.getOption("api-key").get();

            if (apiKey == null)
                throw new IllegalArgumentException("no api key");
            
            AirlyService service = new AirlyService();
            service.setAPIkey(apiKey);

            Response response = null;

            if (parser.hasOption("latitude") || parser.hasOption("longitude"))
                response = service.getPointMeasurement(parser.getOption("latitude").orElseThrow(IllegalArgumentException::new),
                        parser.getOption("longitude").orElseThrow(IllegalArgumentException::new));
            else if (parser.hasOption("sensor-id"))
                response = service.getSensorMeasurement(parser.getOption("sensor-id").orElseThrow(IllegalArgumentException::new));
            else
                throw new IllegalArgumentException("bad");

            Printer printer = new Printer(response);

            if (parser.hasOption("history"))
                printer.printHistory();
            else
                printer.printCurrent();
        } catch (IllegalArgumentException|IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
