package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class menu extends AppCompatActivity {
    public static RankingLogics ranking = new RankingLogics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        TextView textUsuari = (TextView) findViewById(R.id.usuari);
        textUsuari.setText(ranking.getUsuariActual().getNom());

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        TextView textUsuari = (TextView) findViewById(R.id.usuari);
        textUsuari.setText(ranking.getUsuariActual().getNom());
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

    public void onClickButtonJugar(View view){

        Intent intent = new Intent(this, Nivells2Activity.class);
        startActivity(intent);

    }

    public void onClickButtonRanking(View view){

        Intent intent = new Intent(this, RankingView.class);
        startActivity(intent);

    }

    public void onClickButtonHelp(View view){
        Intent intent = new Intent(this, HelpPage.class);
        startActivity(intent);

    }

}
