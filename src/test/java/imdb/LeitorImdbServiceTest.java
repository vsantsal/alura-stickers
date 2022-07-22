package imdb;

import utilitarios.IRequisicionavel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeitorImdbServiceTest {

    @Test
    public void testObtemTextoRespostaConformeEsperado(){

        LeitorImdbService leitorImdbService = new LeitorImdbService(
                TipoApi.TOP_250, "chave_teste", new StubRequisicionavel()
        );
        leitorImdbService.demandaServico();
        assertEquals(new StubRequisicionavel().getBody(),
                leitorImdbService.obtemTextoResposta());

    }


}

class StubRequisicionavel implements IRequisicionavel{

    @Override
    public void sendRequisicao(String url) {

    }

    @Override
    public String getBody() {
        return "texto";
    }
}
