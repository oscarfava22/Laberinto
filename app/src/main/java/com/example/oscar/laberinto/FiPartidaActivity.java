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

    /**
     * Variable que emmagatzema el nivell actual.
     */
    private int nivell;

    /**
     * Variable que conte les estrelles obtingudes per l'usuari.
     */
    private int estrelles;

    /**
     * Metode que mostrara les estrelles que ha obtingut l'usuari per pantalla, aixi com opcions per reiniciar el nivell o tornar al menu de nivells.
     */
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

    /**
     * Metode que fa que es reinicii el nivell que ha jugat l'usuari, finalitzant l'activitat actual.
     */
    public void onClickReiniciarNivell () {

        Intent intent = new Intent (FiPartidaActivity.this, Partida2Activity.class);
        intent.putExtra("nivell", nivell);
        startActivity(intent);
        finish(); //Finalitzem activitat actual. No volem que al tirar enrere tornir a la pregunta.
    }

    /**
     * Metode que redirecciona al menu de nivells, finalitzant l'activitat actual.
     */
    public void onClickTornarAlMenu(){

        Intent intent = new Intent (FiPartidaActivity.this, Nivells2Activity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Metode que mostra per pantalla les estrelles obtingudes, de color groc, per l'usuari segons el nombre d'estrelles que rep com a parametre.
     * @param estrelles: parametre entre 0 i 3 segons el qual es mostrara per pantalla aquest nombre d'estrelles iluminades.
     */
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
