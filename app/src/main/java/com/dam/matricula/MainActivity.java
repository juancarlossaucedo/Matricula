package com.dam.matricula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    private RadioButton cuota4, cuota5, cuota6;

    private TextView tvCostoCarrera;
    private  TextView tvPension;

    private RadioGroup radioGroup;
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

        radioGroup = findViewById(R.id.rbnt);
        radioGroup.check(R.id.rbt4);

        chkCBiblioteca = findViewById(R.id.chkCBiblioteca);
        chkCMedio = findViewById(R.id.chkCMedio);

        tvCostoCarrera=findViewById(R.id.tvCostoCarrera);
        tvPension=findViewById(R.id.tvPension);
        tvGastosAdicionales = findViewById(R.id.tvGastosAdicionales);
        tvTotalPagar = findViewById(R.id.tvTotalPagar);


        cuota4=findViewById(R.id.rbt4);
        cuota5=findViewById(R.id.rbt5);
        cuota6=findViewById(R.id.rbt6);

        btnCalcular=findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });


        // Define los arrays
        String[] opcionesSpinner1 = {"FIA", "FCE", "Teologia"};
        String[] opcionesFIA = {"Tec. de la Información", "Sistemas"};
        String[] opcionesFCE = {"Administración", "Contabilidad"};
        String[] opcionesTeo = {"Biblia"};

        // Definir costos
        carreraCosts = new HashMap<>();
        carreraCosts.put("Tec. de la Información", 3000.0);
        carreraCosts.put("Sistemas", 3000.0);
        carreraCosts.put("Administración", 4000.0);
        carreraCosts.put("Contabilidad", 4500.0);
        carreraCosts.put("Biblia", 3000.0);





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


    private void calculateTotal() {
        String carreraSeleccionada = spinner2.getSelectedItem().toString();
        double costoCarrera = carreraCosts.get(carreraSeleccionada);


        // Calcular gastos adicionales
        double gastosAdicionales = 0.0;
        if (chkCBiblioteca.isChecked()) {
            gastosAdicionales += 25.0;
        }
        if (chkCMedio.isChecked()) {
            gastosAdicionales += 25.0;
        }

        // Calcular Cuotas

        double Numerodecuota = 0.0;
        RadioButton[] cuotas = { cuota4, cuota5, cuota6 };
        int[] cuotaValues = { 4, 5, 6 };

        for (int i = 0; i < cuotas.length; i++) {
            if (cuotas[i].isChecked()) {
                Numerodecuota = costoCarrera / cuotaValues[i];
                break;
            }
        }


        // Calcular total a pagar
        double totalPagar = costoCarrera + Numerodecuota + gastosAdicionales;

        // Mostrar los resultados en los TextViews correspondientes
        tvCostoCarrera.setText(String.format("S/ %.2f", costoCarrera));
        tvPension.setText(String.format("S/ %.2f", Numerodecuota));
        tvGastosAdicionales.setText(String.format("S/ %.2f", gastosAdicionales));
        tvTotalPagar.setText(String.format("S/ %.2f", totalPagar));

        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
    }
}