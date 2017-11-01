package cl.ucn.disc.dam.discnews.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.ucn.disc.dam.discnews.model.Article;
import cl.ucn.disc.dam.discnews.model.NewsApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
/**
 * Representa una noticia para el sistema de noticias del DISC
 *
 * @author Claudio González Salazar
 */

public final class NewsController {

    /**
     * Url de la que se obtendrán los {@link Article}s.
     */
    final String url=" https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=cc22db81b3c14970ab67091440cdb008";


    /**
     * Cliente OkHttp
     */
    final OkHttpClient client = new OkHttpClient();

    /**
     * Des-Serializador GSON
     */
    private static final Gson gson= new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()//TODO: Eliminar en modo produccion
            .create();


    /**
     * Obtención de {@link Article}s desde internet.
     * @return the {@link List} of {@link Article}.
     */
    public List<Article> getArticles() throws IOException {
        //peticion
        final Request request = new Request.Builder()
                .url(url)
                .build();
        //respuesta
        Response response = client.newCall(request).execute();
        final String json = response.body().string();

        final NewsApi na= gson.fromJson(json,NewsApi.class);
        return na.getArticles();
    }
}


