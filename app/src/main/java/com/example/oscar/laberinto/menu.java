package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);


    }

    public void onClickButtonInstructions(View view){

        Intent itent = new Intent(this, instruccionsJoc.class);
        startActivity(itent);

        //anirem a una altre pestanya per canviar el nom
    }


}