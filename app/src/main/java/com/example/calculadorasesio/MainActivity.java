package com.example.calculadorasesio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irABlue (View view){
        Intent i = new Intent(this, Blue.class);
        startActivity(i);
    }
    public void irATarjeta (View view){
        Intent i = new Intent(this, Tarjeta.class);
        startActivity(i);
    }
}