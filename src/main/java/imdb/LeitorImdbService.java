package imdb;

import utilitarios.IRequisicionavel;

public class LeitorImdbService {

    private final IRequisicionavel requisionavel;
    private final TipoApi tipoApi;
    private final String chave;

    public LeitorImdbService(TipoApi tipoApi, String chave, IRequisicionavel requisionavel) {
        this.tipoApi = tipoApi;
        this.chave = chave;
        this.requisionavel = requisionavel;
    }

    public void demandaServico(){
        String url = tipoApi.getUrl(chave);
        this.requisionavel.sendRequisicao(url);
    }

    public String obtemTextoResposta(){
        return this.requisionavel.getBody();
    }

    
}
