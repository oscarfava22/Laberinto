package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by oscar on 11/02/2018.
 */

public class ifragment2 extends android.support.v4.app.Fragment{
    private static final String TAG = "Com Jugar";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_jugar_fragment,container,false);

        return view;
    }
}
