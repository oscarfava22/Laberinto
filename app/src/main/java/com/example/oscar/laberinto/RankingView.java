package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * S'encarrega de mostrar el rànking
 */
public class RankingView extends AppCompatActivity {

    private final RankingLogics rankingLogics;


    public RankingView() {
        rankingLogics = menu.ranking;
    }

    /**
     * Mostra el content del ranking, afegint a una listView els fragments a mostrar. Afegim anar enrere.
     * @param savedInstanceState Perform initialization of all fragments and loaders.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ranking);

        ListView listView = (ListView) findViewById(R.id.ranking_listview);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rankingLogics.getArrayByOrder()));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}

