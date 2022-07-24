package nasa;

import utilitarios.EditorImagem;

public class RedimensionadorApodNasa {

    private final EditorImagem leitorImagem;

    public RedimensionadorApodNasa(EditorImagem leitorImagem) {
        this.leitorImagem = leitorImagem;
    }

    public void salvaImagemRedimensionada(String nomeArquivoSaida,
                                          int offsetAltura,
                                          int offsetLargura) {
        this.leitorImagem.processa();
        this.leitorImagem.redimensiona(offsetAltura, offsetLargura);
        this.leitorImagem.salva(nomeArquivoSaida);
    }

}
