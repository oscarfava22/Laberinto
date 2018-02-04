package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class canviPantallaOpcio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_canvi_pantalla_opcio);



    }
    public void reciveIntent(){
       Intent intent = getIntent();
    }
    /** Called when the user taps the Send button */
    public void onClickButton(View view) {
        Intent canviPantallaOpcioIncial = new Intent(this, firstActivity.class);
        //activa o desactiva volum

            (firstActivity.volum) = true;

            startActivity(canviPantallaOpcioIncial);


    }

    public void onClickButtonTwo(View view){

        Intent canviNom = new Intent(this, CanviNom.class);
        startActivity(canviNom);

        //anirem a una altre pestanya per canviar el nom

    }

}
