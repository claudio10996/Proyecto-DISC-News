package cl.ucn.disc.dam.discnews.Activities;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

import cl.ucn.disc.dam.discnews.R;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
