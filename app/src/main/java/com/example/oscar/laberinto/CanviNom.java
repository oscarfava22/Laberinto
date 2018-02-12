package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CanviNom extends AppCompatActivity {
    public static String nom = "Aquest nom es per defecte";

    public String getNom(){
        return nom;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_canvi_nom);
        TextView textView = (TextView ) findViewById(R.id.editText);
        textView.setText(getNom());

    }

    public void onClickButtonTree (View view){

        EditText editText = (EditText) findViewById(R.id.editText);
        nom = editText.getText().toString();
    }
}
