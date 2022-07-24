package nasa;

import excecoes.NasaAPIException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NasaAPITest {

    private final NasaAPI nasaAPI = NasaAPI.APOD;

    @Test
    public void testDeveRetornarURLcomApiDEMOKEYSESeParametrosForNulo(){
        String urlEsperada = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        String urlObtida = nasaAPI.getUrl(null);
        assertEquals(urlEsperada, urlObtida);
    }

    @Test
    public void testDeveLancarNasaAPIExceptionSeParametroInexistente(){
        assertThrows(
                NasaAPIException.class,
                () -> nasaAPI.getUrl(Map.of("chave_inexiste", "valor_qualquer"))
        );
    }

    @Test
    public void testDeveRetornarStringDeChamadaApiNASAParaParametroComUmaChaveExistente(){
        Map<String, String> params = Map.of("date", "2022-07-01");
        StringBuilder urlEsperada = new StringBuilder(
                "https://api.nasa.gov/planetary/apod?");
        for (var param: params.entrySet()){
            urlEsperada
                    .append(param.getKey())
                    .append("=")
                    .append(param.getValue());
        }

        String urlObtida = nasaAPI.getUrl(params);
        assertEquals(urlEsperada.toString(), urlObtida);
    }

    @Test
    public void testDeveRetornarStringDeChamadaApiNASAParaParametroComMaisChavesExistentes(){
        Map<String, String> params = Map.of(
                "date", "2022-07-01",
                "api_key", "chave_teste");
        StringBuilder urlEsperadaAux = new StringBuilder(
                "https://api.nasa.gov/planetary/apod?");
        for (var param: params.entrySet()){
            urlEsperadaAux
                    .append(param.getKey())
                    .append("=")
                    .append(param.getValue())
                    .append("&");
        }
        String urlEsperada = urlEsperadaAux.toString();
        String urlObtida = nasaAPI.getUrl(params);
        assertEquals(urlEsperada.substring(0, urlEsperada.length() - 1),
                urlObtida);
    }
}