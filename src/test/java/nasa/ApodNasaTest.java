package nasa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilitarios.EditorImagemDiretorio;
import utilitarios.LeitorPropriedades;

import java.io.File;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ApodNasaTest {

    private final Properties propriedades = new LeitorPropriedades("src/test/resources/application.properties")
            .getProps();
    private final String diretorio = propriedades.getProperty("diretorio.arquivos.testes");
    private final String arquivoSaida = propriedades.getProperty("arquivo.testes.apod.output");
    private final String arquivoEntrada = propriedades.getProperty("arquivo.testes.apod.input");

    @BeforeEach
    public void setUp() {
        File arquivo = new File(diretorio +arquivoSaida + ".png");
        arquivo.delete();
    }


    public void testExisteArquivoEditadoPorApodNasa(){

        ApodNasa apodNasa = new ApodNasa(
                new EditorImagemDiretorio(diretorio + arquivoEntrada)
        );

        String tituloTeste = "teste";
        apodNasa.salvaImagemComTitulo(100,
                100,
                tituloTeste,
                diretorio,
                arquivoSaida);

        File arquivo = new File(diretorio +arquivoSaida + ".png");
        assertTrue(arquivo.exists());
    }


}