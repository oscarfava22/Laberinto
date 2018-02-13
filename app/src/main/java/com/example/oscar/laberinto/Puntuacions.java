package com.example.oscar.laberinto;

/**
 * Created by oscar on 13/02/2018.
 */

/**
 * Emmagatzema la informacio de la quantitat de nivells i les puntuacions per a cadascu.
 */
public class Puntuacions {
    private int [][] puntuacions; //nivellsestrella i temps per cada estrella
    public static final int nivells = 10;
    private final int tempsInicial = 60; //x segons

    public Puntuacions(){
        puntuacions = new int[nivells][3]; //casella 0 = 0 estrelles
        for (int i = 0; i < nivells; i++){

            puntuacions[i][0]  = tempsInicial - i * 2; //una estrella
            puntuacions[i][1]  = tempsInicial - i * 3; //dues estrelles
            puntuacions[i][2]  = tempsInicial - i * 4; //tres estrelles
        }
    }

    /**
     * Aquesta funcio retornara les estrelles en funcio de quan triga l'usuari
     * @param temps: temps d'una partida realitzada
     * @param nivell: nivell al que es troba l'usuari
     * @return les estrelles obtingudes
     */
    public int atribuirPuntuacio(int temps, int nivell){
        int estrelles = 0;

        if(temps >= puntuacions[nivell][0]){
        }
        else if(temps <= puntuacions[nivell][0] && temps >= puntuacions[nivell][1]){
            estrelles = 1;
        }else if(temps <= puntuacions[nivell][1] && temps >= puntuacions[nivell][2]){
            estrelles = 2;
        }else{
            estrelles = 3;
        }
        return estrelles;
    }
}
