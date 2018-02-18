package com.example.oscar.laberinto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Nivells2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivells2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Selecció de nivell");

        ImageButton nivell1 = (ImageButton) findViewById(R.id.nivell1);
    }

    public void clickNivell1(View view){
        Intent intent = new Intent (Nivells2Activity.this, Partida2Activity.class);
        intent.putExtra("nivell", 1); //Pasem el nivell a la activity partida
        startActivity(intent);
    }

    public void clickNivell2(View view){
        Intent intent = new Intent (Nivells2Activity.this, Partida2Activity.class);
        intent.putExtra("nivell", 2); //Pasem el nivell a la activity partida
        startActivity(intent);
    }

    public void clickNivell3(View view){
        Intent intent = new Intent (Nivells2Activity.this, Partida2Activity.class);
        intent.putExtra("nivell", 3); //Pasem el nivell a la activity partida
        startActivity(intent);
    }

    public void clickNivell4(View view){
        Intent intent = new Intent (Nivells2Activity.this, Partida2Activity.class);
        intent.putExtra("nivell", 4); //Pasem el nivell a la activity partida
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
