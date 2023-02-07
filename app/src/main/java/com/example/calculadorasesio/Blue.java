package com.example.calculadorasesio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Blue extends AppCompatActivity {
    private TextView tv,res;
    private EditText et;
    private final int precioDolarHoy = 373;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue);

        tv = findViewById(R.id.tvDolar);
        res = findViewById(R.id.tvTotal2);
        et = findViewById(R.id.editTextInput1);
    }

    public void irAMain (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void calcular(View view) {
        tv.setText(String.valueOf("$ "+precioDolarHoy + " ARG"));
        float dolars = Float.parseFloat(et.getText().toString());

        if (dolars == 0) {
            
            res.setText("ERROR!");
        }
        else{
            dolars = dolars / precioDolarHoy;
            res.setText((String.valueOf("$ "+dolars)));
        }
    }
}