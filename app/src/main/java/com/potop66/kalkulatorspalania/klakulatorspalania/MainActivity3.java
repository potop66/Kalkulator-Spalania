package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity3 extends ActionBarActivity {
     TextView wynik;
    EditText kwota,cena;
    String kwota2, cena2,wynik2;
    float kwota1,cena1,wynik1;
    int a=0;
    TextWatcher tw;


    public MainActivity3(){
        tw =new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    kwota2 = kwota.getText() + "";
                    cena2 = cena.getText() + "";
                    kwota1 = Float.parseFloat(kwota2);
                    cena1 = Float.parseFloat(cena2);
                    wynik.setText("0.0");
                    wynik1 = kwota1 / cena1;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                    return;
                }catch (Exception var2_6){
                    wynik.setText("0.0");
                    return;
            }
        }
    };


    }
    @Override
    public void onBackPressed (){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        kwota=(EditText) findViewById (R.id.editText4);
        cena=(EditText) findViewById (R.id.editText5);
        wynik=(TextView) findViewById (R.id.textView9);

        kwota.addTextChangedListener(tw);
        cena.addTextChangedListener(tw);
    }
}
