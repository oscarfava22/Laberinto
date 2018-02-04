package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class CanviNom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_canvi_nom);
    }

    public void reciveIntent(){
        Intent intent = getIntent();
    }
    public String canviNom(View view){

        String nom = "";
        //donar-li el nom quan ell ho escrigui
        return nom;
    }

}
