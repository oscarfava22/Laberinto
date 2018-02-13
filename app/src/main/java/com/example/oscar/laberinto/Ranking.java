package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {
    private static int id = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ranking);

        View linearLayout =  findViewById(R.id.ranking);

        TextView ranking = new TextView(this);
        ranking.setText("hallo hallo");

        ranking.setId(findId());

        ranking.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT));

        ((LinearLayout) linearLayout).addView(ranking);

        //ranking.setId(2000);
        //((LinearLayout) linearLayout).addView(ranking);

       //why cant add another

    }
     public int findId(){
        View v = findViewById(id);
        while (v != null){
            v = findViewById(++id);
        }
        return id++;
    }
}

