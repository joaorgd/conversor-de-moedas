import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public String buscaTaxasDeCambio(String moedaBase) { // O parâmetro 'moedaBase' será usado
        String apiKey = "579ebb01d18f225591175b9e";

        // Usamos a variável 'apiKey' e o parâmetro 'moedaBase' para montar a URL CORRETAMENTE
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaBase);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao consultar a API: " + e.getMessage());
            throw new RuntimeException("Não foi possível obter as taxas de câmbio.", e);
        }
    }
}