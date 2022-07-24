package utilitarios;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EditorImagem {

    private String enderecoImagem;

    private Graphics2D graphics2D;
    private BufferedImage referenciaImagem;
    private BufferedImage referenciaImagemRedimensionada;

    public EditorImagem(String enderecoImagem) {
        this.enderecoImagem = enderecoImagem;
        processa();
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

    public void redimensiona(int offsetAltura, int offsetLargura) {
        this.referenciaImagemRedimensionada = new BufferedImage(
                referenciaImagem.getWidth() + offsetLargura,
                referenciaImagem.getHeight() + offsetAltura,
                BufferedImage.TRANSLUCENT
        );
        graphics2D = (Graphics2D) this.referenciaImagemRedimensionada.getGraphics();
    }

    public void escreveEm(String texto, int x, int y) {
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawString(texto,
                x,
                this.referenciaImagemRedimensionada.getHeight() - y);
    }

    public void salva(String nomeArquivo){

        graphics2D.drawImage(this.referenciaImagem, 0, 0, null);

        try {
            ImageIO.write(this.referenciaImagemRedimensionada, "png", new File(nomeArquivo));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) {
        var geradora = new EditorImagem("https://apod.nasa.gov/apod/image/2207/a11pan1040226lftsm.jpg");
        geradora.processa();
        geradora.redimensiona(200, 0);
        geradora.escreveEm("TOPZERA", 100, 100);
        geradora.salva("src/main/resources/imagem-reprocessada.png");
    }

}

