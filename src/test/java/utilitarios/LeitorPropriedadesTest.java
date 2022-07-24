package utilitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LeitorPropriedadesTest {

    private LeitorPropriedades leitor;
    private Properties propriedades;

    public void setUp() {
        String arquivoConfiguracaoTeste = "src/test/resources/application.properties";
        leitor = new LeitorPropriedades(arquivoConfiguracaoTeste);
        propriedades = leitor.getProps();
    }

    @ParameterizedTest
    @CsvSource({"app.nome, nasa", "nasa.key, chave_para_testes"})
    public void testDeveRetornarPropriedadeDisponivelNoArquivo(String chave, String valor){
        this.setUp();
        String propriedade = propriedades.getProperty(chave).toUpperCase();
        assertEquals(valor.toUpperCase(), propriedade);
    }

    @Test
    public void testDeveRetornarNuloSePropriedadeNaoDisponivel() {
        this.setUp();
        String propriedade = propriedades.getProperty("app.nomeNaoExiste");
        assertNull(propriedade);
    }

    @Test
    public void testDeveRetornarRunTimeExceptionParaArquivoNaoExistente() {
        assertThrows(
                RuntimeException.class,
                () -> leitor = new LeitorPropriedades("tmp/nao-existe")
        );

    }
}
