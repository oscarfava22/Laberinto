package com.example.oscar.laberinto;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


/**
 * Pagina que permet modificar algunes caracteristiques de l'aplicació
 */
public class configuracions extends AppCompatActivity {
    public static Boolean volum = true;
    public static AssetFileDescriptor afd;
    public static MediaPlayer mp;

    /**
     * A l'iniciar l'activity, crea el context visual de la pantalla 'configuracions'. Inicialitza la musica i permet anar enrere.
     * @param savedInstanceState Perform initialization of all fragments and loaders.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            AssetFileDescriptor afd = getAssets().openFd("musica.mp3");
            mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.prepare();
            setContentView(R.layout.configuracions);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * Ens apaga la musica i canvia el boto a mostrar.
     * @param view boto pulsat
     */
    public void onClickButton(View view) {
        Button button = (Button) findViewById(R.id.buttonEngegat);
        button.setVisibility(View.INVISIBLE);
        Button buttonApagat = (Button) findViewById(R.id.buttonApagat);
        buttonApagat.setVisibility(View.VISIBLE);
        volum = false;
        mp.stop();
    }

    /**
     * Ens apaga la musica i canvia el boto a mostrar.
     * @param view boto pulsat
     */
    public void onClickButtonApagat(View view) {
        Button buttonApagat = (Button) findViewById(R.id.buttonApagat);
        buttonApagat.setVisibility(View.INVISIBLE);
        Button button = (Button) findViewById(R.id.buttonEngegat);
        button.setVisibility(View.VISIBLE);
        volum = true;
        mp.start();
    }

    /**
     * Dirigeix a l'activity per canviar nom.
     * @param view boto pulsat
     */
    public void onClickButtonTwo(View view){
        Intent canviNom = new Intent(this, CanviNom.class);
        startActivity(canviNom);
        }

}
