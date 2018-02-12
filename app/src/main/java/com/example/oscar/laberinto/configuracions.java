package com.example.oscar.laberinto;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


// opciones: modificar so, idioma i nom_usuari
public class configuracions extends AppCompatActivity { //classe principal
    public static Boolean volum = true; //inicialment esta engegat
    public static AssetFileDescriptor afd;
    public static MediaPlayer mp;
    @Override
    //mostrarem per pantalla a través d'aquest codi, no modificar.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            AssetFileDescriptor afd = getAssets().openFd("musica.mp3");
            mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.prepare();
            setContentView(R.layout.configuracions);

        } catch (IOException e) {
            e.getMessage();
        }
        if(volum) {
            //posem la musica
            mp.start();

        }else{
            //posem la musica
            mp.stop();
        }
    }
        public void onClickButton(View view) {
            Button button = (Button) findViewById(R.id.button);
            button.setVisibility(View.INVISIBLE);
            Button buttonApagat = (Button) findViewById(R.id.buttonApagat);
            buttonApagat.setVisibility(View.VISIBLE);
            volum = false;
            mp.stop();
        }

        public void onClickButtonApagat(View view) {
            Button button = (Button) findViewById(R.id.buttonApagat);
            button.setVisibility(View.INVISIBLE);
            Button buttonApagat = (Button) findViewById(R.id.button);
            buttonApagat.setVisibility(View.VISIBLE);
            volum = true;
            mp.start();
        }

        public void onClickButtonTwo(View view){

                Intent canviNom = new Intent(this, CanviNom.class);
                startActivity(canviNom);
        }

}
