package main.utilitarios;

public interface IRequisicionavel {
    void sendRequisicao(String url);
    String getBody();
}
