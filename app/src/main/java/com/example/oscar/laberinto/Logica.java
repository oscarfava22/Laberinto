package com.example.oscar.laberinto;

import android.hardware.SensorEvent;
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

    public Logica(int ScreenHeight, int ScreenWidth){

        //Carregar taulell
        //Temporalment:

        //Exemple: ScreenWidth = 1794/1920; ScreenHeight: 1080
        taulell = new boolean [ScreenHeight/10][ScreenWidth/10][4]; //Dividim entre el valor d'avansament de la bola (10), per obtenir en quantes posicions del taulell pot estar la bola.

        for (int i = 0; i < ScreenHeight/10; i++) {

            for (int j = 0; j < ScreenWidth/10; j++) {

                for (int k = 0; k < 4; k++) {
                    taulell[i][j][k] = true;
                }
            }
        }
        /*
        taulell[0][0][0] = true;
        taulell[0][0][1] = false;
        taulell[0][0][2] = false;
        taulell[0][0][3] = false;

        taulell[0][1][0] = true;
        taulell[1][0][0] = false;

        taulell[0][2][1] = true;

        for(int i = 2; i < ScreenWidth/10; i++){
            taulell[1][i][0] = true;
        }

        taulell[1][ScreenWidth/10 - 10][1] = true;
        taulell[2][ScreenWidth/10 - 10][3] = true;
*/
        //Acces a la matriu taulell: taulell[bola.getY()/10][bola.getX()/10]
    }

    public ImageView desplasamentBola(SensorEvent event, int ScreenWidth, int ScreenHeight, ImageView bola) {

        //Desplasament cap a la dreta
        if (event.values[0] > ROTATION_THRESHOLD && bola.getX() < ScreenWidth - 110 && taulell[(int) bola.getY() / 10][(int) bola.getX() / 10][0]) {

            bola.setX(bola.getX() + 10);

        }else if (event.values[0] < -ROTATION_THRESHOLD && bola.getX() > 0 && taulell[(int) bola.getY() / 10][(int) bola.getX() / 10][2]) {

            bola.setX(bola.getX() - 10);

        }
        //Desplasament cap a dalt
        if (event.values[1] > ROTATION_THRESHOLD && bola.getY() > 0 && taulell[(int)bola.getY()/10][(int)bola.getX()/10][3]) {

            bola.setY(bola.getY() - 10);

        }else if (event.values[1] < -ROTATION_THRESHOLD && bola.getY() < ScreenHeight - 170 && taulell[(int)bola.getY()/10][(int)bola.getX()/10][1]) {

            bola.setY(bola.getY() + 10);
        }
        return bola;
    }

    public ImageView inicialitzaPosicioBola(ImageView bola, int nivell, int ScreenWidth, int ScreenHeight) {

        bola.setX(630); //FER EN FUNCIO DEL TAMANY DE LA PANTALLA
        bola.setY(207);

        return bola;
    }

    public boolean comprovarFiPartida(ImageView bola, int nivell) {

        int x_final = 0, y_final = 0;

        switch (nivell){

            case 1:

                x_final = 500;
                y_final = 300;
                break;

            case 2:
                x_final = 400;
                y_final = 800;
                break;

            //TODO
        }

        if (bola.getX() == x_final && bola.getY() == y_final){

            return true;
        }

        return false;
    }

}

