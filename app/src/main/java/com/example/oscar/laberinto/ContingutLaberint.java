package com.example.oscar.laberinto;

/**
 * Created by Ramon on 17/02/2018.
 */

public class ContingutLaberint {

    public static boolean[][][] laberint1() {

        boolean [][][] taulell = new boolean[58][58][4]; //La 3a component si val: 0-anar cap a la dreta, 1-anar cap a abaix, 2-anar cap a esquerra, 3-anar cap a dalt

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

        taulell[28][16][1] = true;
        taulell[28][16][2] = true;
        taulell[43][16][0] = true;
        taulell[43][16][2] = true;
        taulell[43][16][3] = true;
        taulell[42][16][0] = true;
        taulell[43][15][0] = true;
        taulell[43][15][3] = true;

        taulell[42][28][3] = true;

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

        taulell[56][2][0] = true;
        taulell[56][2][3] = true;

        for (int i = 3; i <= 55; i++) {
            taulell[i][2][0] = true;
            taulell[i][2][1] = true;
            taulell[i][2][3] = true;
            taulell[i][3][1] = true;
            taulell[i][3][2] = true;
            taulell[i][3][3] = true;
        }

        taulell[54][16][1] = true;
        taulell[54][16][2] = true;

        for (int i = 3; i <= 15; i++) {
            taulell[54][i][0] = true;
            taulell[54][i][1] = true;
            taulell[54][i][2] = true;
            taulell[55][i][0] = true;
            taulell[55][i][1] = true;
            taulell[55][i][2] = true;
            taulell[55][i][3] = true;
            taulell[56][i][0] = true;
            taulell[56][i][2] = true;
            taulell[56][i][3] = true;
        }

        taulell[57][14][0] = true;
        taulell[57][14][3] = true;
        for (int i = 55; i <= 57; i++){
            taulell[i][15][0] = true;
            taulell[i][15][1] = true;
            taulell[i][15][2] = true;
            taulell[i][15][3] = true;
            taulell[i][16][1] = true;
            taulell[i][16][2] = true;
            taulell[i][16][3] = true;
        }

        for (int i = 3; i <= 16; i++) {
            taulell[i][15][0] = true;
            taulell[i][15][1] = true;
            taulell[i][15][3] = true;
            taulell[i][16][1] = true;
            taulell[i][16][2] = true;
            taulell[i][16][3] = true;
        }

        taulell [17][15][0] = true;
        taulell [17][15][3] = true;

        for (int i = 16; i <= 28; i++) {
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

        taulell[16][29][1] = true;
        taulell[16][29][2] = true;
        taulell[16][29][3] = true;
        taulell[17][29][3] = true;
        taulell[17][29][2] = true;

        for (int i = 3; i <= 15; i++) {
            taulell[i][28][0] = true;
            taulell[i][28][1] = true;
            taulell[i][28][3] = true;
            taulell[i][29][1] = true;
            taulell[i][29][2] = true;
            taulell[i][29][3] = true;
        }

        taulell [2][28][0] = true;
        taulell [2][28][1] = true;
        taulell [2][55][1] = true;
        taulell [2][55][2] = true;
        taulell [3][55][2] = true;
        taulell [3][55][3] = true;
        taulell [4][55][2] = true;
        taulell [4][55][3] = true;

        for (int i = 29; i <= 54; i++) {
            taulell[2][i][0] = true;
            taulell[2][i][1] = true;
            taulell[2][i][2] = true;
            taulell[3][i][0] = true;
            taulell[3][i][2] = true;
            taulell[3][i][3] = true;
        }

        taulell [2][41][0] = true;
        taulell [2][41][1] = true;
        taulell [2][41][2] = true;

        for (int i = 3; i <= 16; i++) {
            taulell[i][41][0] = true;
            taulell[i][41][1] = true;
            taulell[i][41][3] = true;
            taulell[i][42][1] = true;
            taulell[i][42][2] = true;
            taulell[i][42][3] = true;

        }

        taulell [17][41][3] = true;
        taulell [17][41][0] = true;

        for (int i = 42; i <= 54; i++) {
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

        taulell [15][55][2] = true;
        taulell [15][55][1] = true;

        for (int i = 16; i <= 29; i++) {
            taulell[i][54][0] = true;
            taulell[i][54][1] = true;
            taulell[i][54][3] = true;
            taulell[i][55][1] = true;
            taulell[i][55][2] = true;
            taulell[i][55][3] = true;
        }

        taulell[55][30][2] = true;
        taulell[55][30][3] = true;
        taulell[28][15][0] = true;
        taulell[28][15][1] = true;
        taulell[29][15][0] = true;
        taulell[29][15][1] = true;
        taulell[29][15][3] = true;
        taulell[30][15][0] = true;
        taulell[30][15][1] = true;
        taulell[30][15][3] = true;
        taulell[16][55][2] = true;
        taulell[16][55][3] = true;
        taulell[16][55][1] = true;
        taulell[30][55][3] = true;
        taulell[30][55][2] = true;

        for (int i = 16; i <= 54; i++) {
            taulell[28][i][0] = true;
            taulell[28][i][1] = true;
            taulell[28][i][2] = true;
            taulell[29][i][0] = true;
            taulell[29][i][1] = true;
            taulell[29][i][2] = true;
            taulell[29][i][3] = true;
            taulell[30][i][0] = true;
            taulell[30][i][2] = true;
            taulell[30][i][3] = true;

        }

        taulell[43][15][0] = true;
        taulell[43][15][3] = true;
        for (int i = 29; i <= 42; i++) {
            taulell[i][15][0] = true;
            taulell[i][15][1] = true;
            taulell[i][15][3] = true;
            taulell[i][16][1] = true;
            taulell[i][16][2] = true;
            taulell[i][16][3] = true;
        }

        taulell[41][55][1] = true;
        taulell[41][55][2] = true;

        for (int i = 16; i <= 54; i++) {
            taulell[41][i][0] = true;
            taulell[41][i][1] = true;
            taulell[41][i][2] = true;
            taulell[42][i][0] = true;
            taulell[42][i][1] = true;
            taulell[42][i][2] = true;
            taulell[42][i][3] = true;
            taulell[43][i][0] = true;
            taulell[43][i][2] = true;
            taulell[43][i][3] = true;
        }

        taulell[56][55][2] = true;
        taulell[56][55][3] = true;

        for (int i = 42; i <= 55; i++) {
            taulell[i][54][0] = true;
            taulell[i][54][1] = true;
            taulell[i][54][3] = true;
            taulell[i][55][1] = true;
            taulell[i][55][2] = true;
            taulell[i][55][3] = true;
        }

        taulell[54][28][0] = true;
        taulell[54][28][1] = true;
        taulell[55][28][0] = true;
        taulell[55][28][1] = true;
        taulell[55][28][3] = true;
        taulell[56][28][0] = true;
        taulell[56][28][1] = true;
        taulell[56][28][3] = true;

        for (int i = 29; i <= 54; i++){
            taulell[54][i][0] = true;
            taulell[54][i][1] = true;
            taulell[54][i][2] = true;
            taulell[55][i][0] = true;
            taulell[55][i][1] = true;
            taulell[55][i][2] = true;
            taulell[55][i][3] = true;
            taulell[56][i][0] = true;
            taulell[56][i][2] = true;
            taulell[56][i][3] = true;
        }

        return taulell;
    }

    public static boolean[][][] laberint3() {

        boolean [][][] taulell = new boolean[58][58][4];
        //La 3a component si val: 0-anar cap a la dreta,
        // 1-anar cap a abaix, 2-anar cap a esquerra, 3-anar cap a dalt
        taulell[2][2][0] = true;
        taulell[2][2][1] = true;

        for(int i = 3; i < 29; i++){
            taulell[2][i][0] = true;
            taulell[3][i][0] = true;
            taulell[2][i][2] = true;
            taulell[3][i][2] = true;
        }


        for(int i = 3; i < 56; i++){
            taulell[i][2][1] = true;
            taulell[i][3][1] = true;
            taulell[i][2][3] = true;
            taulell[i][3][3] = true;
        }
        taulell[56][2][3] = true;
        taulell[56][3][3] = true;


        for(int i = 3; i < 57; i++){
            taulell[i][2][0] = true;
            taulell[i][3][2] = true;
        }

        for(int i = 2;i < 16; i++){
            taulell[i][41][0] = true;
            taulell[i][41][3] = true;
            taulell[i][41][2] = true;

        }
        taulell[16][41][2] = true;
        taulell[16][41][3] = true;

        for(int i = 2; i < 16; i++){
            taulell[i][42][0] = true;
            taulell[i][42][1] = true;
            taulell[i][42][2] = true;

        }
        taulell[16][42][2] = true;
        taulell[16][42][3] = true;

        for(int i = 3; i < 16; i++){
            taulell[16][i][2] = true;
            taulell[16][i][0] = true;
            taulell[16][i][1] = true;
        }
        taulell[16][16][2] = true;
        taulell[16][16][1] = true;

        for(int i = 3; i < 16; i++){
            taulell[17][i][2] = true;
            taulell[17][i][0] = true;
            taulell[17][i][3] = true;
        }
        taulell[17][16][2] = true;
        taulell[17][16][1] = true;


        for(int i = 15; i < 30; i++){
            taulell[i][15][0] = true;
            taulell[i][15][1] = true;
            taulell[i][15][3] = true;
        }
        taulell[30][15][3] = true;
        taulell[15][15][3] = false;

        for(int i = 15; i < 30; i++){
            taulell[i][16][1] = true;
            taulell[i][16][3] = true;
            taulell[i][16][2] = true;
        }
        taulell[30][16][3] = true;
        taulell[15][16][3] = false;

        for (int i = 15; i < 29; i++) {
            taulell[30][i][1] = true;
            taulell[30][i][2] = true;
            taulell[29][i][0] = true;
        }
        taulell[30][30][1] = true;
        taulell[30][30][2] = true;

        for (int i = 15; i < 29; i++) {
            taulell[29][i][1] = true;
            taulell[29][i][2] = true;
            taulell[29][i][0] = true;
        }
        taulell[29][29][1] = true;
        taulell[29][29][0] = true;

        for (int i = 29; i < 56; i++) {
            taulell[i][28][1] = true;
            taulell[i][28][3] = true;
            taulell[i][28][0] = true;

        }
        taulell[56][28][0] = true;
        taulell[56][28][3] = true;

        for (int i = 29; i < 56; i++) {
            taulell[i][29][1] = true;
            taulell[i][29][3] = true;
            taulell[i][29][2] = true;

        }
        taulell[56][29][3] = true;
        taulell[56][29][2] = true;

        for (int i = 29; i < 15; i--) {
            taulell[55][i][2] = true;
            taulell[55][i][0] = true;
            taulell[55][i][1] = true;

        }
        taulell[55][15][0] = true;
        taulell[55][15][1] = true;


        for (int i = 29; i < 15; i--) {
            taulell[56][i][2] = true;
            taulell[56][i][0] = true;
            taulell[56][i][3] = true;

        }
        taulell[56][15][3] = true;
        taulell[56][15][0] = true;


        //inicio/final
        taulell[56][15][1] = true;
        taulell[56][16][1] = true;
        taulell[57][16][2] = true;
        taulell[57][15][0] = true;
        taulell[57][16][3] = true;
        taulell[57][15][3] = true;


        for (int i = 2; i < 16; i++) {
            taulell[i][28][0] = true;
            taulell[i][28][3] = true;
            taulell[i][28][1] = true;
        }

        taulell[16][28][0] = true;
        taulell[16][28][3] = true;


        for (int i = 3; i < 16; i++) {
            taulell[i][29][2] = true;
            taulell[i][29][3] = true;
            taulell[i][29][1] = true;
        }

        taulell[16][29][2] = true;
        taulell[16][29][3] = true;

        for (int i = 28; i < 42; i++) {
            taulell[15][i][0] = true;
            taulell[15][i][2] = true;
            taulell[15][i][1] = true;
        }
        taulell[15][42][2] = true;
        taulell[15][42][1] = true;
        taulell[15][28][2] = false;


        for (int i = 28; i < 42; i++) {
            taulell[16][i][0] = true;
            taulell[16][i][2] = true;
            taulell[16][i][3] = true;
        }
        taulell[16][42][2] = true;
        taulell[16][42][3] = true;
        taulell[16][28][2] = false;


        for (int i = 16; i < 2; i--) { //41
            taulell[i][41][1] = true;
            taulell[i][41][3] = true;
            taulell[i][41][0] = true;
        }
        taulell[2][41][1] = true;
        taulell[2][41][0] = true;
        taulell[16][41][1] = false;

        for (int i = 16; i < 2; i--) { //42
            taulell[i][42][1] = true;
            taulell[i][42][3] = true;
            taulell[i][42][2] = true;
        }
        taulell[2][42][1] = true;
        taulell[2][42][2] = true;
        taulell[16][42][1] = false;

        for (int i = 41; i < 55; i++) { //2
            taulell[2][i][2] = true;
            taulell[2][i][0] = true;
            taulell[2][i][1] = true;
        }
        taulell[2][55][2] = true;
        taulell[2][55][1] = true;
        taulell[2][41][2] = false;

        for (int i = 41; i < 55; i++) { //3
            taulell[3][i][2] = true;
            taulell[3][i][0] = true;
            taulell[3][i][3] = true;
        }
        taulell[3][55][2] = true;
        taulell[3][55][3] = true;
        taulell[3][41][2] = false;

        for (int i = 2; i < 43; i++) { //54
            taulell[i][54][3] = true;
            taulell[i][54][1] = true;
            taulell[i][54][0] = true;
        }
        taulell[43][54][3] = true;
        taulell[43][54][0] = true;
        taulell[2][54][3] = false;

        for (int i = 2; i < 43; i++) { //55
            taulell[i][55][3] = true;
            taulell[i][55][1] = true;
            taulell[i][55][2] = true;
        }
        taulell[43][55][3] = true;
        taulell[43][55][2] = true;
        taulell[2][55][3] = false;


        for (int i = 55; i < 41; i--) { //42
            taulell[42][i][0] = true;
            taulell[42][i][2] = true;
            taulell[42][i][1] = true;
        }
        taulell[41][42][0] = true;
        taulell[41][42][1] = true;
        taulell[55][42][0] = false;

        for (int i = 55; i < 41; i--) { //43
            taulell[43][i][0] = true;
            taulell[43][i][2] = true;
            taulell[43][i][3] = true;
        }
        taulell[41][43][0] = true;
        taulell[41][43][3] = true;
        taulell[55][43][0] = false;

        for (int i = 29; i < 56; i++) { //41
            taulell[i][41][3] = true;
            taulell[i][41][1] = true;
            taulell[i][41][0] = true;
        }
        taulell[56][41][3] = true;
        taulell[56][41][0] = true;
        taulell[29][41][3] = false;

        for (int i = 29; i < 56; i++) { //42
            taulell[i][42][3] = true;
            taulell[i][42][1] = true;
            taulell[i][42][2] = true;
        }
        taulell[56][42][3] = true;
        taulell[56][42][2] = true;
        taulell[29][42][3] = false;


        for (int i = 41; i < 58; i++) { //55
            taulell[55][i][2] = true;
            taulell[55][i][0] = true;
            taulell[55][i][1] = true;
        }

        taulell[41][55][2] = false;

        for (int i = 41; i < 58; i++) { //56
            taulell[56][i][2] = true;
            taulell[56][i][0] = true;
            taulell[56][i][3] = true;
        }

        taulell[41][56][2] = false;

        //inicio/final

        //bug
        for (int i = 15; i < 2; i--) {
            taulell[i][42][1] = true;
            taulell[i][42][3] = true;

        }
        taulell[15][42][0] = false;
        taulell[2][41][3] = false;



        return taulell;
    }

    public static boolean[][][] laberint4() {

        boolean[][][] taulell = new boolean[58][58][4];
        //La 3a component si val: 0-anar cap a la dreta,
        // 1-anar cap a abaix, 2-anar cap a esquerra, 3-anar cap a dalt

        //inici
        taulell[3][0][0] = true;
        taulell[3][1][1] = true;

        for (int i = 3; i < 56; i++) { //2
            taulell[i][2][3] = true;
            taulell[i][2][1] = true;
            taulell[i][2][0] = true;
        }
        taulell[56][2][3] = true;
        taulell[56][2][0] = true;
        taulell[3][2][3] = false;

        for (int i = 3; i < 56; i++) { //3
            taulell[i][3][1] = true;
            taulell[i][3][2] = true;
            taulell[i][3][3] = true;
        }
        taulell[56][3][3] = true;
        taulell[56][3][2] = true;
        taulell[3][3][3] = false;


        for (int i = 2; i < 55; i++) { //55
            taulell[55][i][0] = true;
            taulell[55][i][2] = true;
            taulell[55][i][1] = true;
        }
        taulell[55][55][2] = true;
        taulell[55][55][1] = true;
        taulell[55][2][2] = false;

        for (int i = 2; i < 55; i++) { //56
            taulell[56][i][0] = true;
            taulell[56][i][2] = true;
            taulell[56][i][3] = true;
        }
        taulell[56][55][3] = true;
        taulell[56][55][2] = true;
        taulell[56][2][2] = false;



        for (int i = 55; i < 29; i--) { //54
            taulell[i][54][1] = true;
            taulell[i][54][3] = true;
            taulell[i][54][0] = true;
        }
        taulell[29][54][1] = true;
        taulell[29][54][0] = true;
        taulell[55][54][1] = false;

        for (int i = 55; i < 29; i--) { //55
            taulell[i][55][1] = true;
            taulell[i][55][3] = true;
            taulell[i][55][0] = true;
        }
        taulell[29][55][1] = true;
        taulell[29][55][0] = true;
        taulell[55][55][1] = false;


        for (int i = 55; i < 28; i--) { //29
            taulell[29][i][0] = true;
            taulell[29][i][2] = true;
            taulell[29][i][1] = true;
        }
        taulell[28][29][0] = true;
        taulell[28][29][1] = true;
        taulell[55][29][0] = false;

        for (int i = 55; i < 28; i--) { //30
            taulell[30][i][0] = true;
            taulell[30][i][2] = true;
            taulell[30][i][3] = true;
        }
        taulell[28][30][0] = true;
        taulell[28][30][3] = true;
        taulell[55][30][0] = false;


        for (int i = 30; i < 16; i--) { //28
            taulell[i][28][3] = true;
            taulell[i][28][1] = true;
            taulell[i][28][0] = true;
        }
        taulell[16][28][1] = true;
        taulell[16][28][0] = true;
        taulell[30][28][1] = false;

        for (int i = 30; i < 16; i--) { //29
            taulell[i][29][3] = true;
            taulell[i][29][1] = true;
            taulell[i][29][2] = true;
        }
        taulell[16][29][1] = true;
        taulell[16][29][2] = true;
        taulell[30][29][1] = false;

        for (int i = 28; i < 55; i++) { //16
            taulell[16][i][2] = true;
            taulell[16][i][0] = true;
        }
        taulell[16][55][2] = true;
        taulell[16][28][2] = false;
        taulell[55][29][0] = true;



         for (int i = 54; i < 15; i--) { //fila 42
            taulell[42][i][0] = true;
             taulell[42][i][2] = true;
             taulell[42][i][1] = true;
         }
         taulell[15][42][0] = true;
         taulell[15][42][1] = true;
         taulell[54][42][0] = false;

        for (int i = 54; i < 15; i--) { //fila 43
            taulell[43][i][0] = true;
            taulell[43][i][2] = true;
            taulell[43][i][3] = true;
        }
        taulell[15][43][0] = true;
        taulell[15][43][3] = true;
        taulell[54][43][0] = false;

        for (int i = 43; i < 3; i--) { //c 15
            taulell[i][15][1] = true;
            taulell[i][15][3] = true;
            taulell[i][15][0] = true;
        }
        taulell[3][15][1] = true;
        taulell[43][15][1] = false;

        for (int i = 43; i < 3; i--) { //c 16
            taulell[i][16][3] = true;
            taulell[i][16][1] = true;
            taulell[i][16][2] = true;
        }
        taulell[3][16][1] = true;
        taulell[43][16][1] = false;



        for (int i = 15; i < 55; i++) { //c 15
            taulell[3][i][0] = true;
            taulell[3][i][2] = true;
        }
        taulell[3][55][2] = true;
        taulell[3][15][2] = false;


        taulell[1][54][0] = true;
        taulell[1][54][1] = true;
        taulell[1][54][3] = true;

        taulell[1][55][2] = true;
        taulell[1][55][1] = true;
        taulell[1][55][3] = true;

        taulell[2][54][0] = true;
        taulell[2][54][1] = true;
        taulell[2][54][3] = true;

        taulell[2][55][2] = true;
        taulell[2][55][1] = true;
        taulell[2][55][3] = true;

        taulell[3][54][0] = true;
        taulell[3][54][1] = true;
        taulell[3][54][3] = true;

        taulell[3][55][2] = true;
        taulell[3][55][1] = true;
        taulell[3][55][3] = true;
        return taulell;
    }
}