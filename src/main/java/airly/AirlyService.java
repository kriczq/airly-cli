package airly;

import airly.model.Response;
import com.jsoniter.JsonIterator;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class AirlyService {
    private static final String BASE_URL = "https://airapi.airly.eu/v1/";
    private String APIkey;

    public Response getPointMeasurement(String latitude, String longitude) throws IOException {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("latitude", latitude);
        requestParams.put("longitude", longitude);

        return request("mapPoint/measurements", requestParams);
    }

    public Response getSensorMeasurement(String sensorID) throws IOException {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("sensorId", sensorID);

        return request("sensor/measurements", requestParams);
    }

    public void setAPIkey(String key) {
        this.APIkey = key;
    }

    private Response request(String requestURI, Map<String, String> requestParams) throws IOException {
        try {
            HttpClient client = HttpClient.newHttpClient();

            String encodedURI = requestParams.keySet().stream()
                    .map(key -> key + "=" + requestParams.get(key))
                    .collect(joining("&", BASE_URL + requestURI + "?", ""));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(encodedURI))
                    .header("apikey", APIkey)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

            switch (response.statusCode()) {
                case 401|403: throw new IOException("api key rejected");
                case 500: throw new IOException("server error");
            }

            //System.out.println(response.statusCode());
            //System.out.println(response.body());

            JsonIterator iter = JsonIterator.parse(response.body());
            Response parsed = iter.read(Response.class);

            return parsed;
        } catch (URISyntaxException|InterruptedException ex) {
            throw new IOException("connection failed");
        }
    }
}
