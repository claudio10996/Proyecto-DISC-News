package cl.ucn.disc.dam.discnews.model;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.time.LocalDateTime;

import lombok.*;

/**
 * Representa una noticia para el sistema de noticias del DISC
 *
 * @author Claudio González Salazar
 */

@Builder
public final class Noticia {

    /**
     * Descripcion en una linea del titulo de la Noticia
     */
    @Getter
    private String titulo;

    /**
     * Descripcion en 2 lineas y con un maximo de 140 chars
     */
    @Getter
    private String resumen;

    /**
     * Contenido completo de la Noticia
     */
    @Getter
    private String contenido;

    /**
     * Fecha de la noticia
     */
    @Getter
    private LocalDateTime fecha;

    /**
     * Icono de la noticia de 64x64 piels.
     */
    @Getter
    private String icono;

    /**
     * Autor de la noticia en formato: "Claudio González <cgs020@alumnos.ucn.cl>
     */
    @Getter
    private String autor;

    @Override
    public String toString() {
        return ToStringBuilder
                .reflectionToString(this,
                        ToStringStyle.MULTI_LINE_STYLE);
    }

}
