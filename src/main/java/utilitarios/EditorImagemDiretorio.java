package utilitarios;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class EditorImagemDiretorio extends EditorImagemBase{

    private final String enderecoImagem;

    public EditorImagemDiretorio(String enderecoImagem) {
        this.enderecoImagem = enderecoImagem;

    }


    @Override
    public void processa() {
        try {
            this.referenciaImagem = ImageIO.read(new File(enderecoImagem));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
