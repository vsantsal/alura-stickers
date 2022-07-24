package nasa;

import utilitarios.IEditorImagem;

public class ApodNasa {

    private final IEditorImagem editorImagem;

    public ApodNasa(IEditorImagem editor) {
        this.editorImagem = editor;
    }

    public void salvaImagemComTitulo(int abscissa,
                                     int ordenada,
                                     String titulo,
                                     String nomeDiretorioSaida,
                                     String nomeArquivo) {
        this.editorImagem.processa();
        this.editorImagem.escreveEm(titulo, abscissa, ordenada);
        this.editorImagem.salvaComo(nomeDiretorioSaida + nomeArquivo + ".png");
    }

}
