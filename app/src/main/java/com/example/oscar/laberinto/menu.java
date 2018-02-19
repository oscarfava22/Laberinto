package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Gestiona la pantalla inicial que permet anar a 'qualsevol' part del programa.
 */
public class menu extends AppCompatActivity {
    public static RankingLogics ranking = new RankingLogics();

    /**
     * A l'iniciar l'activity, crea el context visual de la pantalla 'menu'. Ens permet anar a les altres pantalles i puntuar el joc.
     * @param savedInstanceState Perform initialization of all fragments and loaders.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        TextView textUsuari = (TextView) findViewById(R.id.usuari);
        textUsuari.setText(ranking.getUsuariActual().getNom());
    }

    /**
     * Actualitza el nom de l'usuari quan tornem al menu.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        TextView textUsuari = (TextView) findViewById(R.id.usuari);
        textUsuari.setText(ranking.getUsuariActual().getNom());
    }

    /**
     * Anem a l'activity de instruccions de joc
     * @param view boto pulsat
     */
    public void onClickButtonInstructions(View view){

        Intent intent = new Intent(this, instruccionsJoc.class);
        startActivity(intent);

    }

    /**
     * Anem a l'activity de configuracions
     * @param view boto pulsat
     */
    public void onClickButtonConfiguracions(View view){

        Intent intent = new Intent(this, configuracions.class);
        startActivity(intent);

    }

    /**
     * Anem a l'activity de nivells
     * @param view boto pulsat
     */
    public void onClickButtonJugar(View view){

        Intent intent = new Intent(this, Nivells2Activity.class);
        startActivity(intent);

    }

    /**
     * Anem a l'activity de ranking
     * @param view boto pulsat
     */
    public void onClickButtonRanking(View view){

        Intent intent = new Intent(this, RankingView.class);
        startActivity(intent);

    }

    /**
     * Anem a l'activity d'ajuda
     * @param view boto pulsat
     */
    public void onClickButtonHelp(View view){
        Intent intent = new Intent(this, HelpPage.class);
        startActivity(intent);

    }

}
