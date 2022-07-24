package utilitarios;

import java.util.Properties;

public class LeitorConfiguracoesProjeto {

    private final String ARQUIVO_PROPRIEDADES = "src/main/resources/application.properties";
    private final LeitorPropriedades leitorPropriedades = new LeitorPropriedades(
            ARQUIVO_PROPRIEDADES);

    public String getChaveNasaAPI(){
        return getValor("nasa.key");
    }

    public String getDiretorioArquivos(){
        return getValor("diretorio.imagens.caminho");
    }

    private String getValor(String chave) {
        Properties properties = leitorPropriedades.getProps();
        return properties.getProperty(chave);

    }
}
