package com.example.oscar.laberinto;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by oscar on 14/02/2018.
 */

/**
 * Gestiona rankingView.
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

    /**
     * Hauria de retornar els usuaris al fitxer intern
     * @return: l'array amb els usuaris d'altres partides.
     */
    public ArrayList<Usuari> addCurrentUsers(){
        //TODO
        return this.array;
    }

    /**
     *  Converteix l'array d'usuari a format string, per a ser pintat.
     * @return l'array en format string
     */
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

    /**
     *  Busca si el nom d'usuari ja esta a les dades.
     * @param nom nom a buscar
     * @return si el nom esta repetit o no
     */
    public boolean buscarNomRepetit(String nom){
        for (Usuari usuari:array) {
            if (usuari.getNom() == nom){
                return true;
            }
        }
        return false; //esta repetit
    }

    /**
     * Si l'usuari s'ha trobat a la base de dades, el retornarem.
     * @param nom nom a buscar
     * @return l'usuari trobat a la base de dades
     */
    public Usuari buscarUsuariRepetit(String nom){
        for (Usuari usuari:array) {
            if (usuari.getNom() == nom){
                array.remove(usuari);
                return usuari;
            }
        }
        return null;
    }


    /**
     * Buscarem si el nom esta actualment a les dades, sino l'afegirem.
     * @param nom nom que volem atribuir
     */
    public void cambiarNom(String nom){

        if(buscarNomRepetit(nom)){
            usuariActual = buscarUsuariRepetit(nom);
        }
        else{
            usuariActual.setNom(nom);
        }
    }


}