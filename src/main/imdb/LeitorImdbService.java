package main.imdb;

import main.utilitarios.IRequisicionavel;

public class LeitorImdbService {

    private final IRequisicionavel requisionavel;
    private TipoApi tipoApi;
    private String chave;

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
