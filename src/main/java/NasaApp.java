import nasa.LeitorNasaService;
import nasa.NasaAPI;
import utilitarios.HttpService;
import utilitarios.LeitorConfiguracoesProjeto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class NasaApp {

    public static void main(String[] args) {

        LeitorConfiguracoesProjeto config = new LeitorConfiguracoesProjeto();
        String chaveApi = config.getChaveNasaAPI();
        String hoje = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

        LeitorNasaService leitorNasaService = new LeitorNasaService(
                NasaAPI.APOD,
                Map.of("api_key", chaveApi, "date", hoje),
                new HttpService());

        leitorNasaService.demandaServico();
        System.out.println(leitorNasaService.obtemTextoResposta());
    }

}
