package nasa;

import utilitarios.IRequisicionavel;

import java.util.Map;

public class LeitorNasaService {

    private final IRequisicionavel requisionavel;
    private final NasaAPI nasaAPI;

    private final Map<String, String> parametros;

    public LeitorNasaService(NasaAPI nasaApi, Map<String, String> parametros, IRequisicionavel requisionavel) {
        this.nasaAPI = nasaApi;
        this.parametros = parametros;
        this.requisionavel = requisionavel;
    }

    public void demandaServico(){
        String url = nasaAPI.getUrl(parametros);
        this.requisionavel.sendRequisicao(url);
    }

    public String obtemTextoResposta(){
        return this.requisionavel.getBody();
    }


}
