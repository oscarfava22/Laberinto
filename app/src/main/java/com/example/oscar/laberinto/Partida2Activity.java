package com.example.oscar.laberinto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
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
     * Variable que representa l'index de la casella a la matriu
     */
    private int bola_index [];

    /**
     * Variable que representa la bola
     */
    private ImageView bola;

    /**
     * Variable que representa el laberint
     */
    private ImageView maze;

    /**
    * Variables per obtenir el tamany/densitat de la pantalla del dispositiu
    */
    private int ScreenWidth; //Anchura

    private int ScreenHeight; //Altura

    private int ScreenDensity; //Densitat

    /**
    * Variable de classe Logica per el desplasament de la bola, control del game over i del final de la partida.
    */
    private Logica logic;


    /**
    * Variable que emmagatzema el nivell actual al qual juga l'usuari.
    */
    private int nivell;

    /**
     * Variable que representa el cronometre per mostrar el temps que triga l'usuari a superar el  nivell.
     */
    private Chronometer cronometre;

    /**
     * Metode on s'inicialitzen totes les variables mes importants per la deteccio d'interaccions per part de l'usuari.
     * Tambe per la representacio de la imatge.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida2);

        //Obtenir el sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        rotationSensor = sensorManager != null ? sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) : null;

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
        //No habilitat donat que interessa poder treballar amb els botons si el sensor no esta disponible. Aquesta seria una altra opcio.
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
     * @return int: retorna l'id del drawable a carregar com a laberint segons el nivell.
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

    /**
     * Aquest metode detecta moviments amb els sensors. En cas que hi hagi un canvi al sensor de rotacio notificara gestionara el desplasament de la bola.
     * @param event
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) { // No hi ha suficient precisió

            return;
        }

        if(event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR){

            //Desplasament de la bola
            bola = logic.desplasamentBola(event, ScreenWidth, ScreenHeight, ScreenDensity, bola, bola_index);

            if (logic.comprovarFiPartida(bola_index, nivell)) {

                gestionarFiPartida();
            }

        }

    }

    /**
     * Metode que gestiona el final de la partida: emmagatzemant les dades de la partida i interaccionant amb el jugador.
     */
    private void gestionarFiPartida() {

        int estrelles = new Puntuacions().atribuirPuntuacio((int)((SystemClock.elapsedRealtime() - cronometre.getBase())/100), nivell);

        if (menu.ranking.getUsuariActual().getPuntuacio(nivell) < estrelles) {

            menu.ranking.getUsuariActual().setPuntuacio(nivell, estrelles);
        }
        Intent intent = new Intent (this, FiPartidaActivity.class);
        intent.putExtra("nivell", nivell);
        intent.putExtra("estrelles", estrelles);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * Aquest metode detecta quan l'usuari prem el boto i gestiona el desplasament de la bola cap a la dreta.
     */
    public void onClickBRight (View view){

        bola = logic.desplasamentBotoRight(bola, bola_index, ScreenWidth, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

    }
    /**
     * Aquest metode detecta quan l'usuari prem el boto i gestiona el desplasament de la bola cap a la esquerra.
     */
    public void onClickBLeft (View view) {

        bola = logic.desplasamentBotoLeft(bola, bola_index, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

    }

    /**
     * Aquest metode detecta quan l'usuari prem el boto i gestiona el desplasament de la bola cap a dalt.
     */
    public void onClickBUp (View view) {

        bola = logic.desplasamentBotoUp(bola, bola_index, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

    }

    /**
     * Aquest metode detecta quan l'usuari prem el boto i gestiona el desplasament de la bola cap a abaix.
     */
    public void onClickBDown (View view) {

        bola = logic.desplasamentBotoDown(bola, bola_index, ScreenHeight, ScreenDensity);

        if (logic.comprovarFiPartida(bola_index, nivell)) {

            gestionarFiPartida();
        }

    }

}