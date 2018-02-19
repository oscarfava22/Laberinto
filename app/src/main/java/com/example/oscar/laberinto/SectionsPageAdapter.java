package com.example.oscar.laberinto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by oscar on 12/02/2018.
 */

/**
 * Adapta la pagina de tabs
 */
public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    /**
     *  Permet afegir un nou fragment a les instruccions.
     * @param fragment: cada tab/fragment de les instruccions
     * @param title: rep el titol del fragment
     */
    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    /**
     * S'encarrega de retornar el nom del fragment
     * @param position: rep la posició del fragment
     * @return el nom del fragment
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    /**
     * S'encarrega de retornar el fragment com a objecte
     * @param position: rep la posició del fragment
     * @return retorna el fragment
     */
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    /**
     * Diu quants fragments hi ha
     * @return quantitat fragments
     */
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }
}

