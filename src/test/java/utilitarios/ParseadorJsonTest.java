package utilitarios;

import excecoes.ParseadorJsonException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ParseadorJsonTest {

    @ParameterizedTest
    @CsvSource({"date, 2022-07-23",
            "media_type, image",
             "url, https://apod.nasa.gov/apod/image/2207/a11pan1040226lftsm600.jpg"})
    public void testDeveObterValorNoJsonParaChaveBuscadaSeExistir(String chave,
                                                                  String valorEsperado) {

        ParseadorJson parseadorJson = new ParseadorJson(getTextoTeste());
        String valorObtido = parseadorJson.getValor(chave);
        assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void testDeveLancarExcecaoAoPesquisarChaveInexistente() {
        ParseadorJson parseadorJson = new ParseadorJson(getTextoTeste());
        assertThrows(
                ParseadorJsonException.class,
                () -> parseadorJson.getValor("inexistente")
        );
    }

    private String getTextoTeste() {
        String arquivoJsonTest = "src/test/resources/dados-apod-teste.json";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoJsonTest))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}