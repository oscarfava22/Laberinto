package com.example.oscar.laberinto;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;


// opciones: modificar so, idioma i nom_usuari
public class firstActivity extends AppCompatActivity { //classe principal
    public static Boolean volum = true; //inicialment esta engegat
    public static AssetFileDescriptor afd;
    public static MediaPlayer mp;
    @Override
    //mostrarem per pantalla a través d'aquest codi, no modificar.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //posem la musica
        try {
            AssetFileDescriptor afd = getAssets().openFd("musica.mp3");
            mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
        }catch (IOException e){
            e.getMessage();
        }
    }
        public void reciveIntent(){
            Intent intent = getIntent();
            mp.start();
        }

        /** Called when the user taps the Send button */
        public void onClickButton(View view) {
            Intent canviPantallaOpcio = new Intent(this, canviPantallaOpcio.class);
            //activa o desactiva volum

            this.volum = false;
            mp.stop();


                startActivity(canviPantallaOpcio); //s'anira si inicialment tenim volum apagat
        }

        public void onClickButtonTwo(View view){

                Intent canviNom = new Intent(this, CanviNom.class);
                startActivity(canviNom);

            //anirem a una altre pestanya per canviar el nom

        }

}
