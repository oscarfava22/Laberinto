package com.example.oscar.laberinto;

import android.hardware.SensorEvent;
import android.provider.ContactsContract;
import android.widget.ImageView;

/**
 * Created by Ramon on 09/02/2018.
 */

public class Logica {

    /**

     * Constants pels sensors

     */

    private static final float ROTATION_THRESHOLD = 0.2f;


    //La 3a component si val: 0-anar cap a la dreta, 1-anar cap a abaix, 2-anar cap a esquerra, 3-anar cap a dalt
    private boolean [][][] taulell;

    public Logica(int ScreenHeight, int ScreenWidth, int nivell){

        switch (nivell) {

            case 1:

                taulell = ContingutLaberint.laberint1();
                break;

            case 2:

                taulell = ContingutLaberint.laberint2();
                break;

            case 3:
                taulell = ContingutLaberint.laberint3();
                break;

            case 4:
                taulell = ContingutLaberint.laberint4();
                break;
        }

    }

    public ImageView desplasamentBola(SensorEvent event, int ScreenWidth, int ScreenHeight, int ScreenDensity, ImageView bola, int bola_index []) {

        //Desplasament cap a la dreta
        if (event.values[0] > ROTATION_THRESHOLD && bola_index[1] < 57 && taulell[bola_index[0]][bola_index[1]][0]) {

            bola.setX(bola.getX() + (10 * (float)ScreenDensity / 480));
            bola_index[1] ++;

        }else if (event.values[0] < -ROTATION_THRESHOLD && bola_index[1] > 0 && taulell[bola_index[0]][bola_index[1]][2]) {

            bola.setX(bola.getX() - (10 * (float)ScreenDensity / 480));
            bola_index[1] --;
        }
        //Desplasament cap a dalt
        if (event.values[1] > ROTATION_THRESHOLD && bola_index[0] > 0 && taulell[bola_index[0]][bola_index[1]][3]) {

            bola.setY(bola.getY() - (10 * (float)ScreenDensity / 480));
            bola_index[0] --;

        }else if (event.values[1] < -ROTATION_THRESHOLD && bola_index[0] < 57 && taulell[bola_index[0]][bola_index[1]][1]) {

            bola.setY(bola.getY() + (10 * (float)ScreenDensity / 480));
            bola_index[0] ++;
        }
        return bola;
    }

    public ImageView inicialitzaPosicioBola(ImageView bola, int nivell, int ScreenWidth, int ScreenHeight, int ScreenDensity, int bola_index []) {

        switch (nivell) {

            case 1:

                bola.setX((ScreenWidth / 2) - 320 * ScreenDensity / 480); //FER EN FUNCIO DEL TAMANY DE LA PANTALLA
                bola.setY((ScreenHeight / 2) - 90 * ScreenDensity / 480);
                bola_index [0] = 29;
                bola_index [1] = 2;
                break;

            case 2:

                bola.setX((ScreenWidth / 2) - 190 * ScreenDensity / 480); //FER EN FUNCIO DEL TAMANY DE LA PANTALLA
                bola.setY((ScreenHeight / 2) + 170 * ScreenDensity / 480);
                bola_index [0] = 55;
                bola_index [1] = 15;
                break;

            case 3:

                bola.setX((ScreenWidth / 2) - 190 * ScreenDensity / 480); //FER EN FUNCIO DEL TAMANY DE LA PANTALLA
                bola.setY((ScreenHeight / 2) + 170 * ScreenDensity / 480);
                bola_index [0] = 55;
                bola_index [1] = 15;
                break;

            case 4:

                bola.setX((ScreenWidth / 2) - 320 * ScreenDensity / 480); //FER EN FUNCIO DEL TAMANY DE LA PANTALLA
                bola.setY((ScreenHeight / 2) - 350 * ScreenDensity / 480);
                bola_index [0] = 3;
                bola_index [1] = 2;
                break;
        }
        return bola;
    }

    public boolean comprovarFiPartida(int bola_index [], int nivell) {

        switch (nivell){

            case 1:

                if (bola_index[1] == 0 && (bola_index[0] == 15 || bola_index[0] == 16 || bola_index[0] == 17)) return true;
                break;

            case 2:

                if (bola_index[0] == 57 && (bola_index[1] == 28 || bola_index[1] == 29)) return true;
                break;

            case 3:

                if (bola_index[1] == 57 && (bola_index[0] == 55 || bola_index[0] == 56)) return true;
                break;

            case 4:

                if (bola_index[0] == 0 && (bola_index[1] == 54 || bola_index[1] == 55)) return true;
                break;
        }

        return false;
    }

    public ImageView desplasamentBotoRight(ImageView bola, int[] bola_index, int ScreenWidth, int ScreenDensity) {

        if (bola_index[1] < 57 && taulell[bola_index[0]][bola_index[1]][0]) {

            bola.setX(bola.getX() + (10 * (float)ScreenDensity / 480));
            bola_index[1] ++;
        }
        return bola;
    }

    public ImageView desplasamentBotoLeft (ImageView bola, int[] bola_index, int ScreenDensity){

        if (bola_index[1] > 0 && taulell[bola_index[0]][bola_index[1]][2]) {

            bola.setX(bola.getX() - (10 * (float)ScreenDensity / 480));
            bola_index[1] --;
        }

        return bola;
    }

    public ImageView desplasamentBotoUp(ImageView bola, int[] bola_index, int ScreenDensity) {

        if (bola_index[0] > 0 && taulell[bola_index[0]][bola_index[1]][3]) {

            bola.setY(bola.getY() - (10 * (float)ScreenDensity / 480));
            bola_index[0] --;
        }
        return bola;
    }

    public ImageView desplasamentBotoDown(ImageView bola, int[] bola_index, int screenHeight, int screenDensity) {

        if (bola_index[0] < 57 && taulell[bola_index[0]][bola_index[1]][1]) {

            bola.setY(bola.getY() + (10 * (float)screenDensity / 480));
            bola_index[0] ++;
        }
        return bola;
    }
}

