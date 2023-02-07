package com.example.calculadorasesio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tarjeta extends AppCompatActivity {
    private EditText et;
    private TextView tvImpPais,tvImpGanancias,tvSinImp,tvTotal,tvDolar;
    private int precioDolarHoy = 186;
    private final int pImP = 30;
    private final int pImG = 45;
    private String dolarHoy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta);

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
/**
    protected Void doItBackground(Void... voids){
        String url = "https://dolarhoy.com/";
        String text;
        try {
            Document d = Jsoup.connect(url).get();
            Elements elements = d.select("div.tile is-parent is-7 is-vertical");
            text = elements.text();

            Elements conte = d.select("div.tile is-parent is-7 is-vertical");
            dolarHoy = String.valueOf(conte.select("div.tile is-child").select("div.values").select("div.compra").select("div.val"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
 **/



    public void calcular (View view){
        tvDolar.setText(String.valueOf("$ "+precioDolarHoy));
        float totalImpPais,totalSinImp,totalImpGan,total;
        float dolars = Float.parseFloat(et.getText().toString());

        if (dolars == 0) {
            tvTotal.setText("ERROR!");
        }
        else{
            totalSinImp = dolars * precioDolarHoy;
            totalImpPais = ((dolars / 100) * pImP) * precioDolarHoy;
            totalImpGan = ((dolars / 100) * pImG) * precioDolarHoy;
            total = (totalSinImp + totalImpPais + totalImpGan);

            tvSinImp.setText(String.valueOf("$ "+totalSinImp));
            tvImpPais.setText(String.valueOf("$ "+totalImpPais));
            tvImpGanancias.setText(String.valueOf("$ "+totalImpGan));
            tvTotal.setText((String.valueOf("$ "+total)));
        }
    }

}

