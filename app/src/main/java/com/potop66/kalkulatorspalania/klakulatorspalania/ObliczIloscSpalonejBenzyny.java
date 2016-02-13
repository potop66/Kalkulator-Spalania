package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class ObliczIloscSpalonejBenzyny extends ActionBarActivity {
    TextView wynik;
    EditText przejechaneKm,spalanieNa100km;
    TextWatcher tw;
    Double przejechaneKmD, spalanieNa100kmD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oblicz_ilosc_spalonej_benzyny);
        wynik = (TextView) findViewById(R.id.textView5);
        przejechaneKm = (EditText) findViewById(R.id.editText);
        spalanieNa100km = (EditText) findViewById(R.id.editText3);
        przejechaneKm.addTextChangedListener(tw);
        spalanieNa100km.addTextChangedListener(tw);
    }

    public ObliczIloscSpalonejBenzyny(){
        tw=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    przejechaneKmD=Double.parseDouble(przejechaneKm.getText()+"");
                    spalanieNa100kmD=Double.parseDouble(spalanieNa100km.getText()+"");
                    Double wynik1=(przejechaneKmD/100)*spalanieNa100kmD;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    String wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                }catch(Exception var2_5){
                    wynik.setText("0.0");
                }
            }
        };
    }
}
