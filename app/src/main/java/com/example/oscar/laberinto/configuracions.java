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
    public static Boolean volum = false;
    public static AssetFileDescriptor afd;
    public static MediaPlayer mp;

    /**
     * A l'iniciar l'activity, crea el context visual de la pantalla 'configuracions'. Inicialitza la musica i permet anar enrere.
     * @param savedInstanceState Perform initialization of all fragments and loaders.
     */
    @Override
    //mostrarem per pantalla a través d'aquest codi, no modificar.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            AssetFileDescriptor afd = getAssets().openFd("musica.mp3");
            if (mp == null) {
                mp = new MediaPlayer();
                mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                mp.prepare();
                setContentView(R.layout.configuracions);
                Button button = (Button) findViewById(R.id.buttonEngegat);
                button.setVisibility(View.INVISIBLE);
                Button buttonApagat = (Button) findViewById(R.id.buttonApagat);
                buttonApagat.setVisibility(View.VISIBLE);
            }
            if(mp != null && !mp.isPlaying()){
                setContentView(R.layout.configuracions);
                Button button = (Button) findViewById(R.id.buttonEngegat);
                button.setVisibility(View.INVISIBLE);
                Button buttonApagat = (Button) findViewById(R.id.buttonApagat);
                buttonApagat.setVisibility(View.VISIBLE);
            }
            else if (mp != null && mp.isPlaying()){
                setContentView(R.layout.configuracions);
                Button buttonApagat = (Button) findViewById(R.id.buttonApagat);
                buttonApagat.setVisibility(View.INVISIBLE);
                Button button = (Button) findViewById(R.id.buttonEngegat);
                button.setVisibility(View.VISIBLE);
            }
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
        mp.pause();
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
        if(!mp.isPlaying()) {
            mp.start();
        }
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
