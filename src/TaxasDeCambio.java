import java.util.Map;

    /* Este record representa a estrutura da resposta JSON da API de câmbio.
       Usamos apenas os campos relevantes para a nossa aplicação:
       o código da moeda base e o mapa de taxas de conversão.*/

    public record TaxasDeCambio(String base_code, Map<String, Double> conversion_rates) {

    }
