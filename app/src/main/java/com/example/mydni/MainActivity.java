package com.example.mydni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout LL = (findViewById(R.id.caja_raiz));
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        LL.startAnimation(animacion);
    }

    public void calcularDNI(View view) {
        String sDNI = ((EditText)(findViewById(R.id.caja_dni))).getText().toString();
        sDNI = String.format("%08d",Integer.parseInt(sDNI));

        RadioGroup rBG = ((RadioGroup)(findViewById(R.id.radiogroup_extranjero)));
        String sRB = ((RadioButton)findViewById(rBG.getCheckedRadioButtonId())).getText().toString();
        switch (sRB){
            case "Nacional (sin letra)":  // Nacional
                //Nothing to do
                break;
            case "X":  // X
                sDNI = "1" + sDNI.substring(1,7);
                break;
            case "Y":  // Y
                sDNI = "2" + sDNI.substring(1,7);
                break;
            case "Z":  // Z
                sDNI = "3" + sDNI.substring(1,7);
                break;
        }


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
