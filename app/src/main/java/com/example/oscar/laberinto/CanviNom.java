package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Aquesta classe ens permet canviar el nom de l'usuari.
 */
public class CanviNom extends AppCompatActivity {

    private Toast toast1;


    /**
     * A l'iniciar l'activity, crea el context visual de la pantalla 'canvi de nom'. Ens mostra un títol i permet anar enrere.
     * @param savedInstanceState: Perform initialization of all fragments and loaders.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_canvi_nom);
        TextView textView = (TextView) findViewById(R.id.editText);
        textView.setText(menu.ranking.getUsuariActual().getNom());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Canvi de Nom");
        }


    /**
     * Quan l'usuari fagi click, es cambiarà el nom d'usuari i apareixerà un missatge confirmant el canvi.
     * @param view: rep la imatge corresponent
     */
    public void onClickButtonTree (View view){

        EditText editText = (EditText) findViewById(R.id.editText);
        menu.ranking.cambiarNom(editText.getText().toString());
        editText.setText(menu.ranking.getUsuariActual().getNom());
        menu.ranking.cambiarNom(editText.getText().toString());

        //toasting popUp
        toast1 = Toast.makeText(getApplicationContext(), "Nom d'usuari canviat", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.RIGHT|Gravity.TOP|Gravity.START, 0, 30);
        toast1.show();



    }
}
