package com.example.oscar.laberinto;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;


import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;


public class instruccionsJoc extends AppCompatActivity {

    private static final String TAG = "instruccionsJoc";
    private  SectionsPageAdapter mSectionsPageAdapter;

    private  ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruccions_joc);
        Log.d(TAG, "onCreate: instructions");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewpager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewpager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs); //error
        tabLayout.setupWithViewPager(mViewpager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ifragment1(),"Moviments");
        adapter.addFragment(new ifragment2(),"Com Jugar");
        adapter.addFragment(new ifragment3(),"Puntuacions");
        viewPager.setAdapter(adapter);

    }
}


