import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaApi {

    private String getApiKey() throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            return props.getProperty("API_KEY");
        }
    }

    public String buscaTaxasDeCambio(String moedaBase) {
        try {
            String apiKey = getApiKey();
            if (apiKey == null || apiKey.trim().isEmpty()) {
                throw new IOException("Chave de API não encontrada no arquivo config.properties");
            }

            URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaBase);

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