package com.example.oscar.laberinto;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class Partida2Activity extends AppCompatActivity implements SensorEventListener{
    /**

     * Sensors

     */

    private SensorManager sensorManager;

    private Sensor rotationSensor;


    /**

     * Variables dels textos per mostrar els valors del giroscopi (PER FER PROVES)

     */

    private TextView mRotx;

    private TextView mRoty;

    private TextView mRotz;

    private TextView bola_posX;

    private TextView bola_posY;

    private int bola_index []; // Indica l'index de la casella a la matriu


    /**
     *
     * Variable que representa la bola
     */
    private ImageView bola;

    /**
     * Variable que representa el laberint
     */
    private ImageView maze;

    /*
    * Variables per obtenir el tamany/densitat de la pantalla del dispositiu
    *
    * */
    private int ScreenWidth; //Anchura
    private int ScreenHeight; //Altura
    private int ScreenDensity; //Densitat

    /*
    *
    * Variable de classe Logica per el desplasament de la bola, control del game over i del final de la partida.
    */
    private Logica logic;


    /*
    * Variable que emmagatzema el nivell actual al qual juga l'usuari.
    * */
    private int nivell;

    /**
     * Variable que representa el cronometre per mostrar el temps que triga l'usuari a superar el  nivell.
     */
    private Chronometer cronometre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida2);

        //Obtenir el sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        //Obtenir tamany pantalla del dispositiu
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ScreenHeight = displayMetrics.heightPixels;
        ScreenWidth = displayMetrics.widthPixels;
        ScreenDensity = displayMetrics.densityDpi;

        nivell = getIntent().getExtras().getInt("nivell");

        //Definir variable logica
        logic = new Logica(ScreenHeight, ScreenWidth, nivell);

/*
        if (rotationSensor == null){

            Toast toast1 = Toast.makeText(getApplicationContext(), "Sensor de rotacion no disponible.", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER, 0, 0);
            toast1.show();

            finish();

            // Activitat normalment unica: pantalla principal del dispositiu.
            Intent intent = new Intent (Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
*/
        mRotx = (TextView) findViewById(R.id.rot_x);

        mRoty = (TextView) findViewById(R.id.rot_y);

        mRotz = (TextView) findViewById(R.id.rot_z);

        bola_posX = (TextView) findViewById(R.id.pos_x);

        bola_posY = (TextView) findViewById(R.id.pos_y);

        bola = (ImageView) findViewById(R.id.bola);

        bola_index = new int [2];

        maze = (ImageView) findViewById(R.id.maze_image);

        cronometre = (Chronometer) findViewById(R.id.chronometer2);

        cronometre.start();

        //Inicialitzar posicio bola
        bola = logic.inicialitzaPosicioBola(bola, nivell, ScreenWidth, ScreenHeight, ScreenDensity, bola_index);

        if (nivell != 1){ //Cal actualitzar la imatge del laberint

            maze.setImageResource(actualitzaLaberint(nivell));
        }

    }

    /**
     * Metode que s'encarrega de retornar l'id corresponent al drawable/imatge pel nivell actual, rebut com a parametre.
     * @return
     */
    public int actualitzaLaberint(int nivell){

        switch (nivell) {

            case 1:

                return R.drawable.maze_66;

            case 2:

                return R.drawable.maze_67;

            case 3:

                return R.drawable.maze_68;

            case 4:

                return R.drawable.maze_73;

            case 5:

                return R.drawable.maze_70;

            case 6:

                return R.drawable.maze_71;

            case 7:

                return R.drawable.maze_72;

            case 8:

                return R.drawable.maze_69;

            default:

                return R.drawable.maze_66;

        }
    }

    @Override
    protected void onResume(){

        super.onResume();
        //Amb la constant SENSOR_DELAY_NORMAL indiquem la frequencia amb la qual es llegiran les dades del sensor
        sensorManager.registerListener(this, rotationSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause(){

        super.onPause();
        sensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) { // No hi ha suficient precisió

            return;
        }

        if(event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR){

            mRotx.setText("x = " + Float.toString(event.values[0])); // DEBUGGING

            mRoty.setText("y = " + Float.toString(event.values[1])); // DEBUGGING

            mRotz.setText("z = " + Float.toString(event.values[2])); // DEBUGGING

            // Desplasament de la bola

            //bola = logic.desplasamentBola(event, ScreenWidth, ScreenHeight, ScreenDensity, bola, bola_index);

            if (logic.comprovarFiPartida(bola_index, nivell)) {

                gestionarFiPartida();
            }

            bola_posX.setText("fila = " + bola_index[0]); // DEBUGGING
            bola_posY.setText("columna = " + bola_index[1]); // DEBUGGING
        }

    }

    private void gestionarFiPartida() {

        /*
        Toast toast1 = Toast.makeText(getApplicationContext(), "Felicitats, has superat el nivell!", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER, 0, 0);
        toast1.show();
        */
        int estrelles = new Puntuacions().atribuirPuntuacio((int)((SystemClock.elapsedRealtime() - cronometre.getBase())/100), nivell);

        if (menu.ranking.getUsuariActual().getPuntuacio(nivell) < estrelles) {

            menu.ranking.getUsuariActual().setPuntuacio(nivell, estrelles);
        }
        Intent intent = new Intent (this, FiPartidaActivity.class);
        intent.putExtra("nivell", nivell);
        intent.putExtra("estrelles", estrelles);
        startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onClickBRight (View view){

        bola = logic.desplasamentBotoRight(bola, bola_index, ScreenWidth, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

        bola_posX.setText("fila = " + bola_index[0]); // DEBUGGING
        bola_posY.setText("columna = " + bola_index[1]); // DEBUGGING
    }

    public void onClickBLeft (View view) {

        bola = logic.desplasamentBotoLeft(bola, bola_index, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

        bola_posX.setText("fila = " + bola_index[0]); // DEBUGGING
        bola_posY.setText("columna = " + bola_index[1]); // DEBUGGING
    }

    public void onClickBUp (View view) {

        bola = logic.desplasamentBotoUp(bola, bola_index, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

        bola_posX.setText("fila = " + bola_index[0]); // DEBUGGING
        bola_posY.setText("columna = " + bola_index[1]); // DEBUGGING
    }

    public void onClickBDown (View view) {

        bola = logic.desplasamentBotoDown(bola, bola_index, ScreenHeight, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

        bola_posX.setText("fila = " + bola_index[0]); // DEBUGGING
        bola_posY.setText("columna = " + bola_index[1]); // DEBUGGING
    }

}