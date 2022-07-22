package imdb;

import imdb.TipoApi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TipoApiTest {

    @Test
    public void testTipoApiDeveRetornarUrlComChavePassada(){
        TipoApi tipoApi = TipoApi.TOP_250;
        String chaveTeste = "chave_teste";
        String urlObtida = tipoApi.getUrl(chaveTeste);
        assertEquals("https://imdb-api.com/en/API/Top250Movies/" + chaveTeste,
                urlObtida);

    }

}
