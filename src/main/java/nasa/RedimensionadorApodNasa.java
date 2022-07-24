package nasa;

import utilitarios.EditorImagem;

public class RedimensionadorApodNasa {

    private final EditorImagem leitorImagem;

    public RedimensionadorApodNasa(EditorImagem leitorImagem) {
        this.leitorImagem = leitorImagem;
    }

    public void salvaImagemRedimensionada(int offsetAltura,
                                          int offsetLargura,
                                          String texto,
                                          String nomeArquivoSaida) {
        this.leitorImagem.processa();
        this.leitorImagem.redimensiona(offsetAltura, offsetLargura);
        this.leitorImagem.escreveEm(texto, offsetAltura, offsetLargura);
        this.leitorImagem.salva(nomeArquivoSaida);
    }

}
