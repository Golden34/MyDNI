package com.example.mydni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MyLetra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_letra);

        Intent intent = getIntent();
        String sletra = intent.getStringExtra("LETRA");
        Log.d("MIAPP", "Letra recibida " + sletra);

        Toast.makeText(this, "LETRA:  " + sletra, Toast.LENGTH_LONG).show();

        TextView vCaja = ((TextView)(findViewById(R.id.caja_letra)));
        vCaja.setText(sletra);

        //ImageView iv = (ImageView)findViewById(R.id.imagen);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        vCaja.startAnimation(animacion);
    }
}
