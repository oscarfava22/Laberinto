package com.example.oscar.laberinto;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by oscar on 14/02/2018.
 */

public class RankingLogics {

    private ArrayList<Usuari> array; //refactor failed so dont change name...
    private Usuari usuariActual;


    public RankingLogics() {
        array = new ArrayList<Usuari>();
        usuariActual = new Usuari("Nom per defecte");
        addCurrentUsers(); //buscar els usuaris que estaven registrats
        array.add(new Usuari("Josep"));
        array.add(new Usuari("Josp"));

    }
    public Usuari getUsuariActual(){
        return usuariActual;
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
        String string = usuariActual.getNom() + " ha conseguit una puntuacio total de: " + usuariActual.getPuntuacioTotal().toString() + " estrelles";
        strings.add(string);
        return strings;
    }

    public boolean buscarNomRepetit(String nom){
        for (Usuari usuari:array) {
            if (usuari.getNom() == nom){
                return true;
            }
        }
        return false; //esta repetit
    }

    public Usuari buscarUsuariRepetit(String nom){
        for (Usuari usuari:array) {
            if (usuari.getNom() == nom){
                return usuari;
            }
        }
        return null;
    }


    public void cambiarNom(String nom){

        if(buscarNomRepetit(nom)){
            usuariActual = buscarUsuariRepetit(nom);
        }
        else{
            usuariActual.setNom(nom);
        }
    }

    public void setArray(ArrayList<Usuari> array) {
        this.array = array;
    }


}