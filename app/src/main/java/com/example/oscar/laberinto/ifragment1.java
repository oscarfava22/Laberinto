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
 * Primer fragment referent als moviments.
 */
public class ifragment1 extends android.support.v4.app.Fragment{
    private static final String TAG = "Moviments";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moviments_fragment,container,false);
        return view;
    }
}
