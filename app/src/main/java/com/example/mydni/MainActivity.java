package com.example.mydni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calcularDNI(View view) {
        String sDNI = ((EditText)(findViewById(R.id.caja_dni))).getText().toString();

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int nRest = (Integer.parseInt(sDNI))%23;
        String sletra = letras.substring(nRest,nRest+1);

        Intent intent = null;
        intent = new Intent(this, MyLetra.class);

        intent.putExtra("LETRA",sletra);
        Log.d("MIAPP", "Letra enviada " + sletra);

        startActivity(intent);
    }
}
