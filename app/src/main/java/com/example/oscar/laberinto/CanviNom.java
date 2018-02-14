package com.example.oscar.laberinto;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CanviNom extends AppCompatActivity {

    /**
     private PopupWindow popupWindow;
     private LayoutInflater layoutInflater;
     private ConstraintLayout relativeLayout;
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_canvi_nom);
        TextView textView = (TextView) findViewById(R.id.editText);
        textView.setText(menu.usuari.getNom());
       // relativeLayout = (ConstraintLayout) findViewById(R.id.relative);
        }


    public void onClickButtonTree (View view){

        EditText editText = (EditText) findViewById(R.id.editText);
        menu.usuari.setNom(editText.getText().toString());
        editText.setText(menu.usuari.getNom());
        menu.canviNomUsuari(editText.getText().toString());

        /**
        //popUp
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.own_pop_up, null);

        popupWindow = new PopupWindow(container, 100, 100, true);
        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 200, 200); //peta

        //wrong doing it!
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
        **/
    }
}
