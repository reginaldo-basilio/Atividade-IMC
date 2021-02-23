package com.example.atividadeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    String nome;
    Double peso, altura;
    TextView tvNome, tvPeso, tvAltura, tvImc;
    DecimalFormat df = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");

        tvNome = findViewById(R.id.textNome);
        tvPeso = findViewById(R.id.textPeso);
        tvAltura = findViewById(R.id.textAltura);
        tvImc = findViewById(R.id.textIMC);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvNome.setText(nome);
        tvPeso.setText(peso.toString());
        tvAltura.setText(altura.toString());
        tvImc.setText(df.format(calculadoraIMC(peso, altura)));

    }

    public Double calculadoraIMC(Double peso, Double altura){
        Double imc = peso / (altura*altura);
        return imc;
    }
}

