package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by oscar on 13/02/2018.
 */

public class cronoTest extends AppCompatActivity {

    private Chronometer cronometre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_layout);
        cronometre = (Chronometer) findViewById(R.id.chronometer);

    }

    public void onClickButtonTest(View view) {
        cronometre.start();
    }


}
