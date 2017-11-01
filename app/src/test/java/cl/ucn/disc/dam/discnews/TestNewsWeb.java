package cl.ucn.disc.dam.discnews;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.ucn.disc.dam.discnews.model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Prueba de una noticia web
 *
 * @author Claudio González Salazar
 */

public final class TestNewsWeb {
    /**
     * Des-Serializador GSON
     */
    private static final Gson gson= new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()//TODO: Eliminar en modo produccion
            .create();


    @Test
    public void testConnection() throws IOException {

        final String url=" https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=cc22db81b3c14970ab67091440cdb008";

        final OkHttpClient client = new OkHttpClient();
        Assertions.assertThat(client).isNotNull();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        Assertions.assertThat(request).isNotNull();

        Response response = client.newCall(request).execute();
        final String json = response.body().string();

        Assertions.assertThat(json).isNotBlank();

        //Des-serializar
            final NewsApi noti= gson.fromJson(json,NewsApi.class);
        Assertions.assertThat(noti).isNotNull();
        System.out.println(noti);
    }


}
