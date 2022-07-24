package utilitarios;

import java.util.Properties;

public class LeitorConfiguracoesProjeto {

    public String getChaveNasaAPI(){
        String ARQUIVO_PROPRIEDADES = "src/main/resources/application.properties";
        LeitorPropriedades leitorPropriedades = new LeitorPropriedades(ARQUIVO_PROPRIEDADES);
        Properties properties = leitorPropriedades.getProps();
        return properties.getProperty("nasa.key");
    }
}
