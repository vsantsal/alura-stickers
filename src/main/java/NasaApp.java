import nasa.LeitorNasaService;
import nasa.NasaAPI;
import nasa.RedimensionadorApodNasa;
import utilitarios.EditorImagem;
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

        RedimensionadorApodNasa redimensionadorApodNasa = new RedimensionadorApodNasa(
                new EditorImagem(parseadorJson.getValor("url"))
        );

        String titulo = parseadorJson.getValor("title");
        redimensionadorApodNasa.salvaImagemRedimensionada(100,
                0,
                titulo,
                config.getDiretorioArquivos() + titulo + ".png"
                );


    }

}
