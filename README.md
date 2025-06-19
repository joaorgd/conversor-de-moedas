# Conversor de Moedas - Desafio Java

![Status](https://img.shields.io/badge/status-concluído-green)
![Java](https://img.shields.io/badge/java-17%2B-blue)
![Maven](https://img.shields.io/badge/maven-4.0-red)

Este projeto é um conversor de moedas desenvolvido em Java. A aplicação funciona via console e permite ao usuário realizar conversões entre diferentes moedas, utilizando taxas de câmbio atualizadas em tempo real através de uma API externa.

## 📜 Descrição

O Conversor de Moedas é uma aplicação de console que consome a API da [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio mais recentes. O usuário pode escolher entre diversas opções de conversão pré-definidas em um menu interativo.

## ✨ Funcionalidades

-   **Conversão em tempo real:** As taxas de câmbio são obtidas dinamicamente a cada execução.
-   **Menu interativo:** Interface de texto simples e intuitiva.
-   **Carregamento Seguro de Chave:** A chave da API é carregada de um arquivo de configuração local e não é exposta no código-fonte.
-   **Conversões disponíveis:**
    -   Dólar Americano (USD) <=> Real Brasileiro (BRL)
    -   E outras moedas da América Latina como ARS, COP, BOB, CLP.

## 🛠️ Tecnologias Utilizadas

-   **Java 17+**
-   **Maven:** Gerenciador de dependências.
-   **Gson:** Biblioteca para manipulação de JSON.
-   **Java `HttpClient`:** Para realizar as requisições à API.

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    cd seu-repositorio
    ```

2.  **Configure a Chave da API:**
    -   Obtenha sua chave de API gratuita no site [ExchangeRate-API](https://www.exchangerate-api.com/).
    -   Na raiz do projeto, crie um arquivo chamado `config.properties`.
    -   Dentro do arquivo, adicione a linha: `API_KEY=SUA_CHAVE_AQUI`.

3.  **Compile e Execute:**
    -   Abra o projeto em sua IDE (IntelliJ, Eclipse, etc.) que suporte Maven. A IDE irá baixar as dependências automaticamente.
    -   Localize a classe `Main.java` e execute o método `main()`.

## 👨‍💻 Autor

**João Roberto**
- [LinkedIn](https://www.linkedin.com/in/joão-roberto-ads/)
- [GitHub](https://github.com/joaorgd)
