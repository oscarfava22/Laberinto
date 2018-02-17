package com.example.oscar.laberinto;

/**
 * Created by Ramon on 17/02/2018.
 */

public class ContingutLaberint {

    public static boolean[][][] laberint1() {

        boolean [][][] taulell = new boolean[58][58][4]; //La 3a component si val: 0-anar cap a la dreta, 1-anar cap a abaix, 2-anar cap a esquerra, 3-anar cap a dalt
/*
        for (int i = 0; i < 58; i++) {

            for (int j = 0; j < 58; j++) {

                for (int k = 0; k < 4; k++) {
                    taulell[i][j][k] = true;
                }
            }
        }
  */
        taulell [2][1][1] = true;
        taulell [2][1][0] = true;

        taulell[2][55][1] = true;
        taulell[2][55][2] = true;

        for (int i = 2; i < 55; i++) {
            taulell [2][i][0] = true;
            taulell [2][i][1] = true;
            taulell [2][i][2] = true;
        }

        taulell[3][1][0] = true;
        taulell[3][1][1] = true;
        taulell[3][1][3] = true;

        taulell[3][55][1] = true;
        taulell[3][55][2] = true;
        taulell[3][55][3] = true;

        for (int i = 2; i < 55; i++) {
            for(int j = 0; j < 4; j++){
                taulell [3][i][j] = true;
            }
        }

        taulell[4][1][0] = true;
        taulell[4][1][3] = true;
        taulell[4][55][1] = true;
        taulell[4][55][2] = true;
        taulell[4][55][3] = true;


        for (int i = 2; i < 55; i++) {
            taulell [4][i][0] = true;
            taulell [4][i][2] = true;
            taulell [4][i][3] = true;
        }

        taulell[2][55][1] = true;
        taulell[2][55][2] = true;

        for (int i = 3; i <= 55; i++) {
            taulell[i][55][1] = true;
            taulell[i][55][2] = true;
            taulell[i][55][3] = true;
            taulell[i][54][0] = true;
            taulell[i][54][1] = true;
            taulell[i][54][3] = true;
        }

        taulell[15][54][1] = true;
        taulell[15][54][2] = true;
        taulell[15][54][3] = true;
        taulell[15][54][0] = true;

        for (int i = 1; i <= 54; i++){
            taulell[15][i][0] = true;
            taulell[15][i][1] = true;
            taulell[15][i][2] = true;
            taulell[16][i][0] = true;
            taulell[16][i][1] = true;
            taulell[16][i][2] = true;
            taulell[16][i][3] = true;
            taulell[17][i][0] = true;
            taulell[17][i][2] = true;
            taulell[17][i][3] = true;
        }

        taulell[56][55][2] = true;
        taulell[56][55][3] = true;
        taulell[56][2][0] = true;
        taulell[56][2][3] = true;

        for (int i = 3; i < 55; i++){
            taulell[56][i][0] = true;
            taulell[56][i][2] = true;
            taulell[56][i][3] = true;
            taulell[55][i][0] = true;
            taulell[55][i][1] = true;
            taulell[55][i][2] = true;
            taulell[55][i][3] = true;
            taulell[54][i][0] = true;
            taulell[54][i][1] = true;
            taulell[54][i][2] = true;
        }

        for (int i = 29; i <= 55; i++) {
            taulell[i][2][0] = true;
            taulell[i][2][1] = true;
            //taulell[i][2][2] = true;
            taulell[i][2][3] = true;
            taulell[i][3][1] = true;
            taulell[i][3][2] = true;
            taulell[i][3][3] = true;
        }

        for(int i = 0; i <= 15; i++) {
            taulell[28][i][0] = true;
            taulell[28][i][1] = true;
            taulell[28][i][2] = true;
            taulell[29][i][0] = true;
            taulell[29][i][2] = true;
            taulell[29][i][3] = true;
        }

        for (int i = 29; i <= 42; i++){
            taulell[i][15][0] = true;
            taulell[i][15][1] = true;
            taulell[i][15][3] = true;
            taulell[i][16][1] = true;
            taulell[i][16][2] = true;
            taulell[i][16][3] = true;

        }

        taulell[41][16][0] = true;
        taulell[28][16][1] = true;
        taulell[28][16][2] = true;
        taulell[43][16][0] = true;
        taulell[43][16][2] = true;
        taulell[43][16][3] = true;
        taulell[42][16][0] = true;
        taulell[43][15][0] = true;
        taulell[43][15][3] = true;

        for(int i = 16; i <= 28; i++) {
            taulell[42][i][0] = true;
            taulell[42][i][1] = true;
            taulell[42][i][2] = true;
            taulell[43][i][0] = true;
            taulell[43][i][2] = true;
            taulell[43][i][3] = true;
        }
        taulell[42][29][1] = true;
        taulell[42][29][2] = true;
        taulell[42][29][3] = true;

        for (int i = 29; i < 42; i++) {
            taulell[i][28][0] = true;
            taulell[i][28][1] = true;
            taulell[i][28][3] = true;
            taulell[i][29][1] = true;
            taulell[i][29][2] = true;
            taulell[i][29][3] = true;
        }

        taulell [28][28][0] = true;
        taulell [28][28][1] = true;
        taulell [28][42][1] = true;
        taulell [28][42][2] = true;

        for (int i = 29; i <= 41; i++) {
            taulell[28][i][0] = true;
            taulell[28][i][1] = true;
            taulell[28][i][2] = true;
            taulell[29][i][0] = true;
            taulell[29][i][2] = true;
            taulell[29][i][3] = true;
        }
        taulell[29][42][1] = true;
        taulell[29][42][2] = true;
        taulell[29][42][3] = true;

        for (int i = 30; i <= 42; i++) {
            taulell[i][41][0] = true;
            taulell[i][41][1] = true;
            taulell[i][41][3] = true;
            taulell[i][42][1] = true;
            taulell[i][42][2] = true;
            taulell[i][42][3] = true;
        }

        taulell [43][29][3] = true;
        taulell [43][29][2] = true;

        taulell [43][42][3] = true;
        taulell [43][42][2] = true;

        taulell [43][41][3] = true;
        taulell [43][41][0] = true;



        return taulell;
    }

    public static boolean[][][] laberint2() {

        boolean [][][] taulell = new boolean[58][58][4]; //La 3a component si val: 0-anar cap a la dreta, 1-anar cap a abaix, 2-anar cap a esquerra, 3-anar cap a dalt

        taulell[2][2][0] = true;
        taulell[2][2][1] = true;
        taulell[2][16][1] = true;
        taulell[2][16][2] = true;

        for (int i = 3; i <= 15; i++) {
            taulell[2][i][0] = true;
            taulell[2][i][1] = true;
            taulell[2][i][2] = true;
            taulell[3][i][0] = true;
            taulell[3][i][2] = true;
            taulell[3][i][3] = true;
        }

        for (int i = 3; i <= 55; i++) {
            taulell[i][2][0] = true;
            taulell[i][2][1] = true;
            taulell[i][2][3] = true;
            taulell[i][3][1] = true;
            taulell[i][3][2] = true;
            taulell[i][3][3] = true;
        }

        for (int i = 3; i <= 15; i++) {
            taulell[55][i][0] = true;
            taulell[55][i][1] = true;
            taulell[55][i][2] = true;
            taulell[56][i][0] = true;
            taulell[56][i][2] = true;
            taulell[56][i][3] = true;
        }

        for (int i = 55; i <= 57; i++){
            taulell[i][15][0] = true;
            taulell[i][15][1] = true;
            taulell[i][15][3] = true;
            taulell[i][16][1] = true;
            taulell[i][16][2] = true;
            taulell[i][16][3] = true;
        }
        taulell[55][16][1] = true;
        taulell[55][16][2] = true;

        taulell [17][15][0] = true;
        taulell [17][15][3] = true;

        taulell [17][29][3] = true;
        taulell [17][29][2] = true;

        taulell [2][28][0] = true;
        taulell [2][28][1] = true;

        taulell [2][41][0] = true;
        taulell [2][41][1] = true;
        taulell [2][41][2] = true;


        taulell [2][55][1] = true;
        taulell [2][55][2] = true;

        taulell [3][55][1] = true;
        taulell [3][55][2] = true;
        taulell [3][55][0] = true;
        taulell [4][55][3] = true;
        taulell [4][55][2] = true;

        taulell [11][41][0] = true;
        taulell [11][41][3] = true;
        taulell [11][41][1] = true;

        taulell [11][42][3] = true;
        taulell [11][42][1] = true;
        taulell [11][42][2] = true;

        taulell [17][41][3] = true;
        taulell [17][41][0] = true;

        taulell [15][55][2] = true;
        taulell [15][55][1] = true;

        taulell [16][55][2] = true;
        taulell [16][55][3] = true;
        taulell [16][55][1] = true;

        taulell [17][55][3] = true;
        taulell [17][55][1] = true;
        taulell [17][55][2] = true;

        taulell [30][55][3] = true;
        taulell [30][55][2] = true;
        taulell [30][55][3] = true;
        taulell [30][55][2] = true;


        taulell [29][55][1] = true;
        taulell [29][55][2] = true;
        taulell [29][55][3] = true;

        taulell [28][55][3] = true;
        taulell [28][55][2] = true;
        taulell [28][55][1] = true;

        taulell [28][15][0] = true;
        taulell [28][15][1] = true;

        taulell [28][15][0] = true;
        taulell [28][15][2] = true;
        taulell [28][15][3] = true;

        taulell [29][15][0] = true;
        taulell [29][15][2] = true;
        taulell [29][15][3] = true;

        taulell [30][15][0] = true;
        taulell [30][15][2] = true;
        taulell [30][15][3] = true;

        taulell [43][15][0] = true;
        taulell [43][15][3] = true;

        taulell [42][15][0] = true;
        taulell [42][15][3] = true;
        taulell [42][15][1] = true;


        taulell [42][15][3] = true;
        taulell [42][15][0] = true;
        taulell [42][15][1] = true;

        taulell [41][55][2] = true;
        taulell [41][55][1] = true;

        taulell [42][55][2] = true;
        taulell [42][55][1] = true;
        taulell [42][55][3] = true;

        taulell [42][55][3] = true;
        taulell [42][55][2] = true;
        taulell [42][55][1] = true;

        taulell [56][55][2] = true;
        taulell [56][55][3] = true;

        taulell [55][55][2] = true;
        taulell [55][55][3] = true;
        taulell [55][55][1] = true;

        taulell [54][55][1] = true;
        taulell [54][55][2] = true;
        taulell [54][55][3] = true;

        taulell [54][28][0] = true;
        taulell [54][28][1] = true;

        taulell [55][28][3] = true;
        taulell [55][28][0] = true;
        taulell [55][28][1] = true;

        taulell [59][16][3] = true;
        taulell [59][16][2] = true;

        taulell [59][15][0] = true;
        taulell [59][15][2] = true;
        taulell [59][15][1] = true;

        taulell [59][14][3] = true;
        taulell [59][14][0] = true;

        taulell [55][16][2] = true;
        taulell [55][16][1] = true;

        taulell [56][16][3] = true;
        taulell [56][16][2] = true;
        taulell [59][16][1] = true;

        taulell [56][2][3] = true;
        taulell [56][2][0] = true;

        taulell [55][2][3] = true;
        taulell [55][2][1] = true;
        taulell [55][2][0] = true;

        taulell [54][2][3] = true;
        taulell [54][2][0] = true;
        taulell [54][2][1] = true;
        taulell [43][3][3] = true;
        taulell [43][3][2] = true;
        taulell [43][3][1] = true;

        return taulell;
    }
}
