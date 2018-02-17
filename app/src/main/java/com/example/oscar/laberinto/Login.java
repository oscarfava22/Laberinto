package com.example.oscar.laberinto;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;


public class Login extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickButtonLogin (View view){

        AutoCompleteTextView editText = (AutoCompleteTextView) findViewById(R.id.user);
        //buscar si el teniem a la base de dades
        menu.ranking.cambiarNom(editText.getText().toString());
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }
}

