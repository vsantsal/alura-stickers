import nasa.LeitorNasaService;
import nasa.NasaAPI;
import nasa.ApodNasa;
import utilitarios.EditorImagemURL;
import utilitarios.HttpService;
import utilitarios.LeitorConfiguracoesProjeto;
import utilitarios.ParseadorJson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class NasaApp {

    public static void main(String[] args) {

        LeitorConfiguracoesProjeto config = new LeitorConfiguracoesProjeto();
        String chaveApi = config.getChaveNasaAPI();
        String hoje = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE);

        LeitorNasaService leitorNasaService = new LeitorNasaService(
                NasaAPI.APOD,
                Map.of("api_key", chaveApi, "date", hoje),
                new HttpService());

        leitorNasaService.demandaServico();

        ParseadorJson parseadorJson = new ParseadorJson(
                leitorNasaService.obtemTextoResposta()
        );

        ApodNasa redimensionadorApodNasa = new ApodNasa(
                new EditorImagemURL(parseadorJson.getValor("url"))
        );

        String titulo = parseadorJson.getValor("title");
        redimensionadorApodNasa.salvaImagemComTitulo(100,
                100,
                titulo,
                config.getDiretorioArquivos(),
                titulo
                );


    }

}
