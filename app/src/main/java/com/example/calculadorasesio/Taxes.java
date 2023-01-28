package com.example.calculadorasesio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Taxes extends AppCompatActivity {
    private EditText et;
    private TextView tvImpPais,tvImpGanancias,tvSinImp,tvTotal,tvDolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxes);

        et = findViewById(R.id.editTextInput);
        tvSinImp = findViewById(R.id.tvSinImpuestos);
        tvImpPais = findViewById(R.id.tvImpuestoPais);
        tvImpGanancias = findViewById(R.id.tvImpuestoGanancias);
        tvTotal = findViewById(R.id.tvTotal);
        tvDolar = findViewById(R.id.tvDolar);
    }

    public void irAMain (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void calcular (View view){
        int precioDolarHoy = 185;
        tvDolar.setText(String.valueOf(precioDolarHoy));
        int pImP = 30;
        int pImG = 45;
        float totalImpPais,totalSinImp,totalImpGan,total;
        float dolars = Float.parseFloat(et.getText().toString());
        if (dolars == 0)  {
            tvTotal.setText("ERROR!");
        }
        else{
            totalSinImp = dolars * precioDolarHoy;
            totalImpPais = ((dolars / 100) * pImP) * precioDolarHoy;
            totalImpGan = ((dolars / 100) * pImG) * precioDolarHoy;
            total = (totalSinImp + totalImpPais + totalImpGan);

            tvSinImp.setText(String.valueOf(totalSinImp));
            tvImpPais.setText(String.valueOf(totalImpPais));
            tvImpGanancias.setText(String.valueOf(totalImpGan));
            tvTotal.setText((String.valueOf(total)));
        }
    }

}

