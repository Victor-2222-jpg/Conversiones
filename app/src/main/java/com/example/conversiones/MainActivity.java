package com.example.conversiones;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import Class.Celcius;
import Class.farenheit;
import Class.grados;
import Class.kelvin;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    grados grados = new grados();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = findViewById(R.id.spinnerUnidades);
        Spinner spinner2 = findViewById(R.id.spinnerUnidades2);
        EditText editTextGrados = findViewById(R.id.editTextGrados);
        Button btnConvertir = findViewById(R.id.button);



        btnConvertir.setOnClickListener(this);

        final Celcius celcius = new Celcius();
        final farenheit farenheit = new farenheit();
        final kelvin kelvin = new kelvin();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unidades_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        grados.setTipo("Celsius");

                        break;
                    case 1:
                        grados.setTipo("Fahrenheit");

                        break;
                    case 2:
                        grados.setTipo("Kelvin");

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Your code here
            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        if (grados.getTipo().equals("fahrenheit")) {
                            celcius.parse(farenheit);
                        } else if (grados.getTipo().equals("kelvin")) {
                            celcius.parse(kelvin);
                        }


                        break;
                    case 1:
                        if (grados.getTipo().equals("celsius")) {
                            farenheit.parse(celcius);
                        } else if (grados.getTipo().equals("kelvin")) {
                            farenheit.parse(kelvin);
                        }
                        break;
                    case 2:
                        if (grados.getTipo().equals("celsius")) {
                            kelvin.parse(celcius);
                        } else if (grados.getTipo().equals("fahrenheit")) {
                            kelvin.parse(farenheit);
                        }
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });


    }

    @Override
    public void onClick(View view) {
        EditText editTextGrados = findViewById(R.id.editTextGrados);
        grados.setValor(Double.parseDouble(editTextGrados.getText().toString()));

        TextView resultado = findViewById(R.id.resultado);
        resultado.setText(grados.getValor().toString());


    }
}