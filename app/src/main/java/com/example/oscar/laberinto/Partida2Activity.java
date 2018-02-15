package com.example.oscar.laberinto;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
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
    * Variables per obtenir el tamany de la pantalla del dispositiu
    *
    * */
    private int ScreenWidth; //Anchura
    private int ScreenHeight; //Altura

    /*
    *
    * Variable de classe Logica per el desplasament de la bola, control del game over i del final de la partida.
    */
    private Logica logic;


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

        int nivell = getIntent().getExtras().getInt("nivell");

        //Inicialitzar posicio bola

        bola.setX(ScreenWidth/2 - 340.0f); //FER EN FUNCIO DEL TAMANY DE LA PANTALLA
        bola.setY(ScreenHeight/2 - 98.0f);

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

                return R.drawable.maze_76__thumb1;

            case 2:

                return R.drawable.maze_69__thumb;

            case 3:

                return R.drawable.maze_73__thumb;

            case 4:

                return R.drawable.maze_79__thumb1;

            case 5:

                return R.drawable.maze_89_;

            case 6:

                return R.drawable.maze_90_;

            case 7:

                return R.drawable.maze_96_;

            case 8:

                return R.drawable.maze_94_;

            default:

                return R.drawable.maze_76__thumb1;

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

            bola_posX.setText("x = " + bola.getX());
            bola_posY.setText("y = " + bola.getY());
        }

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