package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by oscar on 11/02/2018.
 */

/**
 * Fragment tercer referent a les puntuacions.
 */
public class ifragment3 extends android.support.v4.app.Fragment{
    private static final String TAG = "Puntuacions";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.puntuacions_fragment,container,false);
        return view;
    }
}
