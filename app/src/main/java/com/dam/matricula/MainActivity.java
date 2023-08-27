package com.dam.matricula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {

    private Spinner spinner1 ;
    private Spinner spinner2;

    private CheckBox chkCBiblioteca;
    private CheckBox chkCMedio;

    private TextView tvGastosAdicionales;
    private TextView tvTotalPagar;

    private  TextView tvPension;

    private Button btnCalcular;

    private ArrayAdapter<String> fiaAdapter;
    private ArrayAdapter<String> fceAdapter;
    private ArrayAdapter<String> teoAdapter;
    private ArrayAdapter<String> datosAdapter;



    private Map<String, Double> carreraCosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner1 = (Spinner) findViewById(R.id.spnEscuela);
        spinner2 = (Spinner) findViewById(R.id.spnCarrera);


        chkCBiblioteca = findViewById(R.id.chkCBiblioteca);
        chkCMedio = findViewById(R.id.chkCMedio);

        tvPension=findViewById(R.id.tvPension);
        tvGastosAdicionales = findViewById(R.id.tvGastosAdicionales);
        tvTotalPagar = findViewById(R.id.tvTotalPagar);

        btnCalcular=findViewById(R.id.btnCalcular);




        // Define los arrays
        String[] opcionesSpinner1 = {"FIA", "FCE", "Teologia"};
        String[] opcionesFIA = {"Tec. de la Información", "Sistemas"};
        String[] opcionesFCE = {"Administración", "Contabilidad"};
        String[] opcionesTeo = {"Biblia"};


        // Adaptadores para los Spinners
        ArrayAdapter<String> spinner1Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesSpinner1);
        fiaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesFIA);
        fceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesFCE);
        teoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesTeo);
        datosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesFIA);

        // Setea los adaptadores en los Spinners
        spinner1.setAdapter(spinner1Adapter);
        spinner2.setAdapter(fiaAdapter); // Configurar el adapter inicial

        // Configura el listener para el spinner1
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String seleccion = spinner1.getSelectedItem().toString();

                switch (seleccion) {
                    case "FIA":
                        spinner2.setAdapter(datosAdapter);
                        break;
                    case "FCE":
                        spinner2.setAdapter(fceAdapter);
                        break;
                    case "Teologia":
                        spinner2.setAdapter(teoAdapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

       


    }
}