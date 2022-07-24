package utilitarios;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class EditorImagemBase implements IEditorImagem {

    private Graphics2D graphics2D;
    protected BufferedImage referenciaImagem;

    public abstract void processa();

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
