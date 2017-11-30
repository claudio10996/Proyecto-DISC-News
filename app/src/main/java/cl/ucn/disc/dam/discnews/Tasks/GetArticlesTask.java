package cl.ucn.disc.dam.discnews.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.logging.Logger;

import cl.ucn.disc.dam.discnews.Activities.MainActivity;
import cl.ucn.disc.dam.discnews.Adapters.ArticleAdapter;
import cl.ucn.disc.dam.discnews.controller.ArticleController;
import cl.ucn.disc.dam.discnews.controller.NewsController;
import cl.ucn.disc.dam.discnews.model.Article;
import lombok.*;

/**
 * @author  Claudio Gonzalez on 09-11-2017.
 */


public final class GetArticlesTask extends AsyncTask<Void, Void, List<Article>> {

    /**
     * Adaptador del articulo.
     */
    private ArticleAdapter articleAdapter;





    @Override
    protected List<Article> doInBackground(Void... voids) {

        // FIXME: Sera atributo de la clase?
        final ArticleController articleController = new ArticleController();

        try {
            // Obtengo los articles desde internet via el controlador
            return articleController.getArticles("techcrunch,ars-technica,engadget,buzzfeed,wired");
        } catch (IOException e) {
            return null;
        }

    }

    @Override
        protected void onPostExecute(List<Article> articles) {
        this.articleAdapter.addAll(articles);
    }

}
