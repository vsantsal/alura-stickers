package utilitarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import excecoes.ParseadorJsonException;

public class ParseadorJson {

    private final String json;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ParseadorJson(String json) {
        this.json = json;
    }

    public String getValor(String chave) {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            return jsonNode.get(chave).asText();
        }
        catch (NullPointerException e) {
            throw new ParseadorJsonException(
                    "Não foi encontrada a chave pesquisada" + chave);
        }
    }




}
