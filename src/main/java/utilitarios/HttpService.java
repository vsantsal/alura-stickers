package utilitarios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService implements IRequisicionavel {

    private String body;

    public void sendRequisicao(String url){
        URI endereco = URI.create(url);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(endereco).GET().build();
        try {
            HttpResponse<String> response =  cliente.send(request, HttpResponse.BodyHandlers.ofString());
            body = response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getBody() {
        return body;
    }
}
