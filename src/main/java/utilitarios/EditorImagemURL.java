package utilitarios;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EditorImagemURL extends EditorImagemBase {

    private final String enderecoImagem;

    private Graphics2D graphics2D;

    public EditorImagemURL(String enderecoImagem) {
        this.enderecoImagem = enderecoImagem;
    }

    public void processa() {
        URL url;
        try {
            url = new URL(enderecoImagem);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            this.referenciaImagem = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escreveEm(String texto, int abscissa, int ordenada) {
        graphics2D = (Graphics2D) this.referenciaImagem.getGraphics();
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 56);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawString(texto,
                abscissa,
                ordenada);
    }

    @Override
    public void salvaComo(String nomeArquivo) {
        graphics2D.drawImage(this.referenciaImagem, 0, 0, null);

        try {
            ImageIO.write(this.referenciaImagem, "png", new File(nomeArquivo));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

