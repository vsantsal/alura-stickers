package utilitarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpServiceTest {


    private HttpService httpService;

    @BeforeEach
    void setUp(){
        this.httpService = new HttpService();
    }

    @Test
    void testDeveRetornarBodyNuloAntesDeRequisicaoEnviada(){
        assertNull(this.httpService.getBody());

    }

}