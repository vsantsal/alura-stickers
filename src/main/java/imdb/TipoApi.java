package imdb;

public enum TipoApi {

    TOP_250 {
        @Override
        public String getUrl(String chave) {
            return "https://imdb-api.com/en/API/Top250Movies/" + chave;
        }

    };

    public abstract String getUrl(String chave);

}
