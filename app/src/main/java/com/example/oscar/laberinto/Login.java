package com.example.oscar.laberinto;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Login extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Toast toast1 = Toast.makeText(getApplicationContext(), usuari.getNom(), Toast.LENGTH_SHORT);
       //toast1.setGravity(Gravity.BOTTOM, 0, 30);
       //toast1.show();
    }

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
        }

    }

}

