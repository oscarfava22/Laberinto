package com.example.oscar.laberinto;

import android.support.annotation.NonNull;

/**
 * Created by oscar on 13/02/2018.
 */

public class Usuari implements Comparable<Usuari>{

    private String nom;
    private int[] puntuacions; //nivells i estrellesNivell


    public Usuari(String nom){
        this.nom = nom;
        this.puntuacions = new int[Puntuacions.nivells];
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Serveix per guardar les estrelles que ha conseguit l'usuari en la partida
     * @param nivell: al nivell que es troba
     * @param estrelles: quantes estrellas ha obtingut
     */
    public void setPuntuacio(int nivell, int estrelles){
        this.puntuacions[nivell - 1] = estrelles;
    }

    /**
     * retornara la quantitat d'estrelles que te l'usuari actualment a un nivell. Serveix per saber si ha millorat o no la puntuacio.
     * @param nivell: nivell actual
     * @return: quantes estrelles te al nivell
     */
    public Integer getPuntuacio(int nivell){
        return this.puntuacions[nivell];
    }

    public Integer getPuntuacioTotal(){
        Integer puntuacio = 0;
        for (int i = 0; i < Puntuacions.nivells; i++) {
            puntuacio += puntuacions[i];
        }
        return puntuacio;
    }

    @Override
    public int compareTo(@NonNull Usuari usuari) {
        int comparingOne = this.getPuntuacioTotal();
        int comparingTwo = usuari.getPuntuacioTotal();
        return comparingTwo - comparingOne;
    }
}
