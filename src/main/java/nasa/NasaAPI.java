package nasa;

import excecoes.NasaAPIException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum NasaAPI {
    APOD {
        @Override
        public String getUrl(Map<String, String> parametros){
            // retornamos url demo se nenhum parâmetro for passado
            if (parametros == null) {
                return "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
            }

            // caso parâmetros sejam passados, construímos a URL
            // se houver algum parâmetro não mapeado pela API, lançamos NasaAPIException
            StringBuilder urlBase = new StringBuilder("https://api.nasa.gov/planetary/apod?");
            for (var entrada : parametros.entrySet()) {
                if (!chaveExisteParaServico(entrada.getKey())){
                    throw new NasaAPIException("Teste");
                }
                urlBase.append(entrada.getKey())
                        .append("=")
                        .append(entrada.getValue())
                        .append("&");
            }

            String urlFinal = urlBase.toString();
            return urlFinal.substring(0, urlFinal.length() - 1);
        }

        private boolean chaveExisteParaServico(String chave){
            Set<String> conjuntoParametros = new HashSet<>();
            conjuntoParametros.add("date");
            conjuntoParametros.add("start_date");
            conjuntoParametros.add("end_date");
            conjuntoParametros.add("count");
            conjuntoParametros.add("thumbs");
            conjuntoParametros.add("api_key");
            return conjuntoParametros.contains(chave);
        }
    };

    public abstract String getUrl(Map<String, String> parametros);
}
