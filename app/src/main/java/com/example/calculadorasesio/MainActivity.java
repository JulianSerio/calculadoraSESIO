package com.example.calculadorasesio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    private TextView tvRes;
    private Float num1 = 0.0f;
    private Float num2 = 0.0f;
    private String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        tvRes = findViewById(R.id.tvResultado);
    }

    public void irACompras(View view){
        Intent i = new Intent(this, Taxes.class);
        startActivity(i);
    }

    public void escribirCero (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("0");
        }else{
            tvRes.setText(tvRes.getText() + "0");
        }
    }

    public void escribirUno (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("1");
        }
        else{
            tvRes.setText(tvRes.getText() + "1");
        }
    }

    public void escribirDos (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("2");
        }else{
            tvRes.setText(tvRes.getText() + "2");
        }
    }

    public void escribirTres (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("3");
        }else{
            tvRes.setText(tvRes.getText() + "3");
        }
    }

    public void escribirCuatro (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("4");
        }else{
            tvRes.setText(tvRes.getText() + "4");
        }
    }

    public void escribirCinco (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("5");
        }else{
            tvRes.setText(tvRes.getText() + "5");
        }
    }

    public void escribirSeis (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("6");
        }else{
            tvRes.setText(tvRes.getText() + "6");
        }
    }

    public void escribirSiete (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("7");
        }else{
            tvRes.setText(tvRes.getText() + "7");
        }
    }

    public void escribirOcho (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("8");
        }else{
            tvRes.setText(tvRes.getText() + "8");
        }
    }

    public void escribirNueve (View view){
        if (tvRes.getText().toString().equals("0")){
            tvRes.setText("9");
        }else{
            tvRes.setText(tvRes.getText() + "9");
        }
    }

    public void dividir(View view){
        op = "÷";
        guardarNumero1(view);
    }

    public void multiplicar(View view){
        op = "x";
        guardarNumero1(view);
    }

    public void restar(View view){
        op = "-";
        guardarNumero1(view);
    }

    public void sumar(View view){
        op = "+";
        guardarNumero1(view);
    }

    public void limpiarTv(View view){
        tvRes.setText("0");
        num1 = 0.0f;
        op = "";
        num2 = 0.0f;
    }

    public void guardarNumero1(View view){
        num1 = Float.parseFloat(tvRes.getText().toString());
        tvRes.setText("0");
    }

    public void borrar (View view){
        String text = tvRes.getText().toString();
        if (0 == text.length()) {
            tvRes.setText("ERROR!");
        }
        else{
                tvRes.setText(text.substring(0, text.length() - 1));
            }
    }

    public void punto (View view){
        tvRes.setText(tvRes.getText() + ".");
    }

    public void igual (View view){
        Float result = 0.0f;
        num2 = Float.parseFloat(tvRes.getText().toString());

        if (op == "+"){
            result = num1 + num2;
            BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.UP);
            tvRes.setText(String.valueOf(bd.floatValue()));

        }
        else{
            if (op == "-"){
                result = num1 - num2;
                BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.UP);
                tvRes.setText(String.valueOf(bd.floatValue()));
            }
            else {
                if (op == "÷") {
                    result = num1 / num2;
                    BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.UP);
                    tvRes.setText(String.valueOf(bd.floatValue()));
                }
                else {
                    if (op == "x"){
                        result = num1 * num2;
                        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.UP);
                        tvRes.setText(String.valueOf(bd.floatValue()));
                    }
                    else{
                        tvRes.setText("ERROR!");
                    }
                }
            }

        }
    }

}