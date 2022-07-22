package utilitarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LeitorPropriedades {

    private final Properties props = new Properties();

    public LeitorPropriedades(String arquivo) {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            this.props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível a leitura do arquivo de propriedades");
        }
    }

    public Properties getProps() {
        return this.props;
    }

}