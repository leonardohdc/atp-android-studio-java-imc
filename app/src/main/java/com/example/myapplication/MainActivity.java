package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton botaoMulher;
    ToggleButton botaoHomem;
    EditText campoIdade;
    EditText campoPeso;
    EditText campoAltura;
    TextView textoSeuIMC;
    TextView resultadoIMC;
    TextView resultadoIMCNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultadoIMC = findViewById((R.id.resultadoIMC));
        resultadoIMCNumero = findViewById((R.id.resultadoIMCNumero));
        botaoMulher = findViewById((R.id.botaoMulher));
        botaoHomem = findViewById((R.id.botaoHomem));
        campoIdade = findViewById((R.id.campoIdade));
        campoPeso = findViewById((R.id.campoPeso));
        campoAltura = findViewById((R.id.campoAltura));
        textoSeuIMC = findViewById((R.id.textoSeuIMC));

        botaoMulher.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                botaoMulher.setChecked(true);
                botaoHomem.setChecked(false);
            }
        });

        botaoHomem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                botaoMulher.setChecked(false);
                botaoHomem.setChecked(true);
            }
        });
    }

    public void botaoCalcularIMC(View v){
        float peso = Float.parseFloat(campoPeso.getText().toString());
        float altura = Float.parseFloat(campoAltura.getText().toString())/100;
        float imc = peso/(altura*altura);

        resultadoIMC.setTypeface(null, Typeface.BOLD);
        textoSeuIMC.setText("Seu IMC ??:");
        if(imc < 18.5){
            resultadoIMC.setText("Magreza");
        } else if(18.5 < imc && imc < 24.9) {
            resultadoIMC.setText("Normal");
        } else if(24.9 < imc && imc < 30) {
            resultadoIMC.setText("Sobrepeso");
        } else {
            resultadoIMC.setText("Obesidade");
        }

        resultadoIMCNumero.setTypeface(null, Typeface.BOLD);
        resultadoIMCNumero.setText(String.format("%.2f", peso/(altura*altura)));
    }
}