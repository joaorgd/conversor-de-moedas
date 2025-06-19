import java.util.Map;

public class Conversor {

    /**
     * Implementa a lógica de conversão de moedas
     * @param valor O montante a ser convertido.
     * @param moedaOrigem O código da moeda de origem (ex: "USD").
     * @param moedaDestino O código da moeda de destino (ex: "BRL").
     * @param taxas O mapa com todas as taxas de conversão baseadas numa moeda principal.
     * @return O valor convertido.
     */
    public static double converterMoeda(double valor, String moedaOrigem, String moedaDestino, Map<String, Double> taxas) {
        Double taxaOrigem = taxas.get(moedaOrigem);
        Double taxaDestino = taxas.get(moedaDestino);

        if (taxaOrigem == null || taxaDestino == null) {
            throw new IllegalArgumentException("Moeda não encontrada. Verifique os códigos.");
        }

        // Fórmula de conversão cruzada usando uma moeda base
        return (valor / taxaOrigem) * taxaDestino;
    }
}