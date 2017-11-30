package cl.ucn.disc.dam.discnews.model;

import android.util.Log;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import lombok.*;

/**
 * EntityUtils Utils.
 *
 * @author Diego Urrutia Astorga.
 */

public final class EntityUtils {

    /**
     * Can't instantiate!
     */
    private EntityUtils() {

    }

    /**
     *
     * @param dateStr
     * @return the {@link DateTime}.
     */
    public static DateTime parse(final String dateStr) {

        try {
            return ISODateTimeFormat.dateTimeNoMillis().parseDateTime(dateStr);
        } catch (IllegalArgumentException ex) {
            // Nothing here ..
        }

        try {
            return ISODateTimeFormat.dateTime().parseDateTime(dateStr);
        } catch (IllegalArgumentException ex) {
            // Nothing here ..
        }

        Log.d("Can't parse date ", dateStr);
        return new DateTime();

    }

}
