package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    public static Usuari usuari = new Usuari("Nom per defecte");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        TextView textUsuari = (TextView) findViewById(R.id.usuari);
        textUsuari.setText(usuari.getNom());

    }

    public void onClickButtonInstructions(View view){

        Intent intent = new Intent(this, instruccionsJoc.class);
        startActivity(intent);

        //anirem a una altre pestanya per canviar el nom
    }
    public void onClickButtonConfiguracions(View view){

        Intent intent = new Intent(this, configuracions.class);
        startActivity(intent);

        //anirem a una altre pestanya per canviar el nom
    }
    /*
    public void onClickButtonJugar(View view){

        Intent intent = new Intent(this, jugar.class);
        startActivity(intent);

        //anirem a una altre pestanya per canviar el nom
    }
    public void onClickButtonRanking(View view){

        Intent intent = new Intent(this, ranking.class);
        startActivity(intent);

        //anirem a una altre pestanya per canviar el nom
    }
    */


}
