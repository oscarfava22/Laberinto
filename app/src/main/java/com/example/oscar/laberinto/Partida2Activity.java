package com.example.oscar.laberinto;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    /**
     * Variables que representen les estrelles segons la puntuacio/temps de l'usuari al acabar el nivell.
     */
    private ImageView estrella1;
    private ImageView estrella2;
    private ImageView estrella3;

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

        //Definir variable logica
        logic = new Logica(ScreenHeight, ScreenWidth);

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

        maze = (ImageView) findViewById(R.id.maze_image);

        nivell = getIntent().getExtras().getInt("nivell");

        cronometre = (Chronometer) findViewById(R.id.chronometer2);

        cronometre.start();

        estrella1 = (ImageView) findViewById(R.id.Star1);

        estrella2 = (ImageView) findViewById(R.id.Star2);

        estrella3 = (ImageView) findViewById(R.id.Star3);

        estrella1.setVisibility(View.INVISIBLE);
        estrella1.setColorFilter(Color.BLACK);
        estrella2.setVisibility(View.INVISIBLE);
        estrella2.setColorFilter(Color.BLACK);
        estrella3.setVisibility(View.INVISIBLE);
        estrella3.setColorFilter(Color.BLACK);

        //Inicialitzar posicio bola
        bola = logic.inicialitzaPosicioBola(bola, nivell, ScreenWidth, ScreenHeight, ScreenDensity);

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

                return R.drawable.maze_69;

            case 5:

                return R.drawable.maze_70;

            case 6:

                return R.drawable.maze_71;

            case 7:

                return R.drawable.maze_72;

            case 8:

                return R.drawable.maze_73;

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

            bola = logic.desplasamentBola(event, ScreenWidth, ScreenHeight, bola);

            if (logic.comprovarFiPartida(bola, nivell)) {

                gestionarFiPartida();
            }

            bola_posX.setText("x = " + bola.getX()); // DEBUGGING
            bola_posY.setText("y = " + bola.getY()); // DEBUGGING
        }

    }

    private void gestionarFiPartida() {

        Toast toast1 = Toast.makeText(getApplicationContext(), "Felicitats, has superat el nivell!", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER, 0, 0);
        toast1.show();

        int estrelles = new Puntuacions().atribuirPuntuacio((int)((SystemClock.elapsedRealtime() - cronometre.getBase())/100), nivell);

        if (menu.usuari.getPuntuacio(nivell) < estrelles) {

            menu.usuari.setPuntuacio(nivell, estrelles);
        }
        mostraEstrelles(estrelles);
        finish();

        // Activitat normalment unica: pantalla principal del dispositiu.
        Intent intent = new Intent (this, Nivells2Activity.class);
        startActivity(intent);
    }

    private void mostraEstrelles(int estrelles) {

        switch(estrelles) {

            case 0:

                estrella1.setColorFilter(Color.GRAY);
                estrella2.setColorFilter(Color.GRAY);
                estrella3.setColorFilter(Color.GRAY);
                break;

            case 1:

                estrella1.setColorFilter(Color.BLACK);
                estrella2.setColorFilter(Color.GRAY);
                estrella3.setColorFilter(Color.GRAY);
                break;

            case 2:

                estrella1.setColorFilter(Color.BLACK);
                estrella2.setColorFilter(Color.BLACK);
                estrella3.setColorFilter(Color.GRAY);
                break;

            case 3:

                estrella1.setColorFilter(Color.BLACK);
                estrella2.setColorFilter(Color.BLACK);
                estrella3.setColorFilter(Color.BLACK);
                break;
        }

        estrella1.setVisibility(View.VISIBLE);
        estrella2.setVisibility(View.VISIBLE);
        estrella3.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * Metode temporal per fer proves. Al pulsar el boto fa avansar la bola horitzontalment, cap a la dreta.
     * @param view
     */
    public void onClickBRight (View view){

        if (bola.getX() < ScreenWidth - 110) {

            bola.setX(bola.getX() + 5);
        }

    }

    public void onClickBLeft (View view) {

        if (bola.getX() > 0) {

            bola.setX(bola.getX() - 5);
        }
    }

    public void onClickBUp (View view) {

        if (bola.getY() > 0) {

            bola.setY(bola.getY() - 5);
        }
    }

    public void onClickBDown (View view) {

        if (bola.getY() < ScreenHeight - 170) {

            bola.setY(bola.getY() + 5);
        }
    }

}