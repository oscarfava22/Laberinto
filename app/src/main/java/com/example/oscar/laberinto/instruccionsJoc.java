package com.example.oscar.laberinto;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;


import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


/**
 * Gestiona les instruccions del joc que mostren la informacio de com jugar.
 */
public class instruccionsJoc extends AppCompatActivity {

    private static final String TAG = "instruccionsJoc";
    private  SectionsPageAdapter mSectionsPageAdapter;

    private  ViewPager mViewpager;

    /**
     * A l'iniciar l'activity, crea el context visual de la pantalla 'instruccions'. Ens col·loca la ViewPager i inicialitzar l'adapter.
     * @param savedInstanceState Perform initialization of all fragments and loaders.
     */
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

    /**
     * Ens afegeix a la activity que conté l'estructura de "tabs" cada fragment.
     * @param viewPager Layout que ens permet anar fent "flip" d'esquerra a dreta pels fragments.
     */
    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ifragment1(),"Moviments");
        adapter.addFragment(new ifragment2(),"Com Jugar");
        adapter.addFragment(new ifragment3(),"Puntuacions");
        viewPager.setAdapter(adapter);

    }
}


