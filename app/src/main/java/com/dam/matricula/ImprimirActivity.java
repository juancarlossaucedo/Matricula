package com.dam.matricula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImprimirActivity extends AppCompatActivity {

    private TextView tvAlumno, tvCostoCareer,tvNumCuotas,tvMontoAdi,tvGastos,
            tvCarrera,tvEscuela,tvPen,tvTotal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir);

        tvAlumno=(TextView) findViewById(R.id.tvAlumno);
        tvCostoCareer=(TextView) findViewById(R.id.tvCostoCareer);
        tvNumCuotas=(TextView) findViewById(R.id.tvNumCuotas);
        tvMontoAdi=(TextView) findViewById(R.id.tvMontoAdi);
        tvGastos=(TextView) findViewById(R.id.tvGastos);
        tvCarrera=(TextView) findViewById(R.id.tvCarrera);
        tvEscuela=(TextView) findViewById(R.id.tvEscuela);
        tvPen=(TextView) findViewById(R.id.tvPen);
        tvTotal=(TextView) findViewById(R.id.tvTotal);

        String dato = getIntent().getStringExtra("datos");
        tvAlumno.setText(dato);

        String dato2 = getIntent().getStringExtra("datos2");
        tvCostoCareer.setText(dato2);

        String dato3 = getIntent().getStringExtra("datos3");
        tvPen.setText(dato3);

        String dato4 = getIntent().getStringExtra("datos4");
        tvMontoAdi.setText(dato4);

        String dato5= getIntent().getStringExtra("datos5");
        tvTotal.setText(dato5);

        String dato6 = getIntent().getStringExtra("datos6");
        tvEscuela.setText(dato6);

    }

    //Regresar

    public void Regresar(View view){

        Intent i = new Intent(this, MainActivity.class);

        startActivity(i);
    }

}
