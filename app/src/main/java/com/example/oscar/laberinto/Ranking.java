package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ranking extends AppCompatActivity {

    private final RankingLogics rankingLogics;

    public Ranking() {
        rankingLogics = new RankingLogics();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ranking);


        ListView listView = (ListView) findViewById(R.id.ranking_listview);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rankingLogics.getArrayByOrder()));


    }
}

