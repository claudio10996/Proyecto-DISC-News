

package cl.ucn.disc.dam.discnews.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.*;


/**
 * Clase generada vía http://www.jsonschema2pojo.org/
 */
@Builder
public final class NewsApi {

    @Getter
    private String status;

    @Getter
    private String source;

    @Getter
    private String sortBy;

    @Getter
    private List<Article> articles;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}