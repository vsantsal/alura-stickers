package utilitarios;

public interface IEditorImagem {
    void processa();
    void escreveEm(String texto, int abscissa, int ordenada);
    void salvaComo(String nomeArquivo);
}
