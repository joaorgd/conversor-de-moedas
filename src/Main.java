import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner leitor = new Scanner(System.in)) {
            ConsultaApi consultaApi = new ConsultaApi();
            Gson gson = new Gson();
            // Obter os dados da API
            System.out.println("Buscando dados de câmbio...");
            String jsonResponse = consultaApi.buscaTaxasDeCambio("USD");
            TaxasDeCambio taxas = gson.fromJson(jsonResponse, TaxasDeCambio.class);
            Map<String, Double> mapaDeTaxas = taxas.conversion_rates();

            // Interagindo com o usuário
            while (true) {
                System.out.println("\n*****************************************************");
                System.out.println("Seja bem-vindo(a) ao Conversor de Moedas");

                // Filtrando as moedas - Apresentando as opções
                System.out.println("\nEscolha uma das 6 opções de conversão:");
                System.out.println("1) Dólar Americano (USD) => Real Brasileiro (BRL)");
                System.out.println("2) Real Brasileiro (BRL) => Dólar Americano (USD)");
                System.out.println("3) Dólar Americano (USD) => Peso Argentino (ARS)");
                System.out.println("4) Dólar Americano (USD) => Peso Colombiano (COP)");
                System.out.println("5) Dólar Americano (USD) => Boliviano Boliviano (BOB)");
                System.out.println("6) Dólar Americano (USD) => Peso Chileno (CLP)");
                System.out.println("7) Sair");
                System.out.println("*****************************************************");
                System.out.print("Digite a sua opção: ");

                String opcao = leitor.nextLine();

                if (opcao.equalsIgnoreCase("7")) {
                    System.out.println("Finalizando o programa. Obrigado!");
                    break;
                }

                System.out.print("Digite o valor que deseja converter: ");
                double valor;
                try {
                    valor = Double.parseDouble(leitor.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor inválido. Tente novamente.");
                    continue;
                }

                String moedaOrigem = "USD"; // A maioria das nossas opções tem USD como origem
                String moedaDestino = "";

                switch (opcao) {
                    case "1":
                        moedaDestino = "BRL";
                        break;
                    case "2":
                        moedaOrigem = "BRL";
                        moedaDestino = "USD";
                        break; // Exceção
                    case "3":
                        moedaDestino = "ARS";
                        break;
                    case "4":
                        moedaDestino = "COP";
                        break;
                    case "5":
                        moedaDestino = "BOB";
                        break;
                    case "6":
                        moedaDestino = "CLP";
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        continue;
                }

                // Convertendo os valores (chamando nosso método modular)
                double resultado = Conversor.converterMoeda(valor, moedaOrigem, moedaDestino, mapaDeTaxas);

                System.out.printf("\n=== O valor de %.2f %s equivale a %.2f %s ===\n",
                        valor, moedaOrigem, resultado, moedaDestino);
            }

        } catch (Exception e) {
            System.err.println("Ocorreu um erro na aplicação: " + e.getMessage());
        }
    }
}