package com.example.atividadeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    String nome;
    Double peso, altura;
    TextView tvNome, tvPeso, tvAltura, tvImc, tvStatus;
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
        tvStatus = findViewById(R.id.textStatus);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvNome.setText(nome);
        tvPeso.setText(peso.toString());
        tvAltura.setText(altura.toString());
        tvImc.setText(df.format(calculadoraIMC(peso, altura)));
        tvStatus.setText(getStatus(peso, altura));
    }
    public Double calculadoraIMC(Double peso, Double altura){
        Double imc = peso / (altura*altura);
        return imc;
    }

    public String getStatus(Double peso, Double altura){
        Double imc = peso / (altura*altura);
        if(imc < 18.5){
            return "Abaixo do peso";
        }else if(imc < 24.9) {
            return "Peso ideal";
        }else if(imc < 29.9) {
            return "Ligeiramente acima do peso";
        }else if(imc < 34.9) {
            return "Obesidade grau I";
        }else if(imc < 39.9) {
            return "Obesidade grau II";
        }else{
            return "Obesidade grau III";
        }
    }

}

