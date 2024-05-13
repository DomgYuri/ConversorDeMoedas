import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public Moeda Converter(String moeda) {
        var busca = moeda;
        var endereco = "https://v6.exchangerate-api.com/v6/a398d94f2942057f1b958bdf/latest/" + busca;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(json).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            Moeda objetoMoeda = gson.fromJson(conversionRates , Moeda.class);
            return objetoMoeda;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro!");
        }
    }

}
