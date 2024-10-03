package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class PincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println("Digite um filme: ");
        Scanner s = new Scanner(System.in);
        var filmeBuscado = s.nextLine();

        var endereco = "https://www.omdbapi.com/?t=" + filmeBuscado + "&apikey=afe6b11e";
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            //Builder é comumente utilizado para criação de objetos complexos. Como por exemplo nesse caso,
            //onde estamos utilizando uma classe abstrata(HttpClient) mas não a instanciamos, utilizamos
            //métodos para referência-lá 
            .build();
        HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());
        System.out.println(response.body());
    }
}