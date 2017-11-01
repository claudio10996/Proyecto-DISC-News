package cl.ucn.disc.dam.discnews;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import cl.ucn.disc.dam.discnews.controller.NewsController;
import cl.ucn.disc.dam.discnews.model.Article;

/**
 * Prueba del controlador de la noticia.
 *
 * @author Claudio González Salazar
 */

public final class TestNewsController {

    @Test
    public void testConnection() throws IOException {
        final NewsController nc= new NewsController();
        final List<Article> articles= nc.getArticles();
        Assertions.assertThat(articles).isNotNull();
        Assertions.assertThat(articles).hasSize(10);
        System.out.println(articles);
    }
}
