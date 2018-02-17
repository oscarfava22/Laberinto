package com.example.oscar.laberinto;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by oscar on 14/02/2018.
 */

public class RankingLogics {

    private ArrayList<Usuari> array;

    public RankingLogics() {
        array = new ArrayList<Usuari>();
        addCurrentUsers();
        Usuari aux = new Usuari("Manolo");
        array.add(aux);
    }

    public ArrayList<Usuari> addCurrentUsers(){
        return this.array;
    }

    public ArrayList<String> getArrayByOrder() {
        ArrayList<String> strings = new ArrayList<String>();

        Iterator iterator = array.iterator();
        int i = 0;
        while(iterator.hasNext()){
            String string = array.get(i).getNom() + " ha conseguit una puntuacio total de: " + array.get(i).getPuntuacioTotal().toString() + " estrelles";
            strings.add(string);
            i++;
            iterator.next();
        }
        return strings;
    }

    public void setArray(ArrayList<Usuari> array) {
        this.array = array;
    }


}
