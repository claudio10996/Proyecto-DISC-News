package cl.ucn.disc.dam.discnews;

import android.app.Application;
import android.util.Log;

import cl.ucn.disc.dam.discnews.dao.AppDatabase;
import com.facebook.device.yearclass.YearClass;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import org.apache.commons.lang3.time.StopWatch;

import lombok.*;



/**
 * @author  Claudio Gonzalez on 09-11-2017.
 */

public class MainApplication extends Application {
    /**
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();

        // Timer
        final StopWatch stopWatch = StopWatch.createStarted();

        // Facebook Fresco
        {
            // Pipeline config
            final ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                    .setDownsampleEnabled(true)
                    .setResizeAndRotateEnabledForNetwork(true)
                    .build();

            // Initialize Fresco
            Fresco.initialize(this, imagePipelineConfig);
        }

        // DBFLow
        {
            // Initialize DBFLow
            FlowManager.init(FlowConfig.builder(this)
                    .addDatabaseConfig(DatabaseConfig.builder(AppDatabase.class).databaseName("articlestore").build())
                    // .openDatabasesOnInit(true)
                    .build()
            );
        }

        // Device-Year
        {
            int year = YearClass.get(this);
            Log.d("Year detected: {}", String.valueOf(year));
        }

        // Timming
        Log.d("Initialization in: {}", String.valueOf(stopWatch));

    }

}
