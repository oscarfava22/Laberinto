package com.example.oscar.laberinto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class FiPartidaActivity extends AppCompatActivity {

    /**
     * Variables que representen les estrelles segons la puntuacio/temps de l'usuari al acabar el nivell.
     */
    private ImageView estrella1;
    private ImageView estrella2;
    private ImageView estrella3;

    int nivell;

    int estrelles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fi_partida);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nivell = getIntent().getExtras().getInt("nivell");

        estrelles = getIntent().getExtras().getInt("estrelles");

        estrella1 = (ImageView) findViewById(R.id.star1);

        estrella2 = (ImageView) findViewById(R.id.star2);

        estrella3 = (ImageView) findViewById(R.id.star3);

        mostraEstrelles(estrelles);

    }

    public void reiniciarNivell () {

        Intent intent = new Intent (FiPartidaActivity.this, Partida2Activity.class);
        intent.putExtra("nivell", nivell);
        startActivity(intent);
        finish(); //Finalitzem activitat actual. No volem que al tirar enrere tornir al AlertDialog.
    }

    public void tornarAlMenu(){

        Intent intent = new Intent (FiPartidaActivity.this, menu.class);
        startActivity(intent);
        finish(); //Finalitzem activitat actual. No volem que al tirar enrere tornir al AlertDialog.
    }


    private void mostraEstrelles(int estrelles) {

        switch(estrelles) {

            case 0:

                estrella1.setColorFilter(Color.GRAY);
                estrella2.setColorFilter(Color.GRAY);
                estrella3.setColorFilter(Color.GRAY);
                break;

            case 1:

                estrella1.setColorFilter(Color.YELLOW);
                estrella2.setColorFilter(Color.GRAY);
                estrella3.setColorFilter(Color.GRAY);
                break;

            case 2:

                estrella1.setColorFilter(Color.YELLOW);
                estrella2.setColorFilter(Color.YELLOW);
                estrella3.setColorFilter(Color.GRAY);
                break;

            case 3:

                estrella1.setColorFilter(Color.YELLOW);
                estrella2.setColorFilter(Color.YELLOW);
                estrella3.setColorFilter(Color.YELLOW);
                break;
        }

        estrella1.setVisibility(View.VISIBLE);
        estrella2.setVisibility(View.VISIBLE);
        estrella3.setVisibility(View.VISIBLE);
    }

}
