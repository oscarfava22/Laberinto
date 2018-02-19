package com.example.oscar.laberinto;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Pantalla que permet a l'usuari establir el seu nom.
 */
public class Login extends AppCompatActivity  {

    private JsonManager jsonManager;
    private String FILENAME = "file";
    private FileOutputStream fos;
    private FileInputStream fis;

    /**
     * A l'iniciar l'activity, crea el context visual de la pantalla 'menu'.
     * @param savedInstanceState Perform initialization of all fragments and loaders.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //carregaFitxer();
        getSupportActionBar().setTitle("Iniciar sessió");
        
    }

    /**
     * Quan prem l'usuari, cambia el nom i anem al menu. Si no escrius res, es motra l'error.
     * @param view boto pulsat
     */
    public void onClickButtonLogin (View view){

        AutoCompleteTextView editText = (AutoCompleteTextView) findViewById(R.id.user);
        //buscar si el teniem a la base de dades
        if(editText.getText().toString().isEmpty()){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Introdueix un nom, no ho deixis en blanc!", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER, 0, 0);
            toast1.show();
        }else {
            menu.ranking.cambiarNom(editText.getText().toString());
                Intent intent = new Intent(this, menu.class);
        startActivity(intent);
        finish();
        }

    }

    /**
     * hauria de carregar el fitxer intern
     */
    public void carregaFitxer(){
        /**
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fis = openFileInput(FILENAME);
            int c;
            temp="";
            while( (c = fis.read()) != -1){
                temp = temp + Character.toString((char)c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         **/
    }
}

