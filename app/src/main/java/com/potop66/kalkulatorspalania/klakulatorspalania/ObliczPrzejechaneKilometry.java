package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class ObliczPrzejechaneKilometry extends ActionBarActivity {
    TextView wynik;
    EditText spalanie,spaloneLitry;
    TextWatcher tw;
    Double spalanie1, spaloneLitry1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6);
        wynik = (TextView) findViewById(R.id.textView22);
        spalanie = (EditText) findViewById(R.id.editText10);
        spaloneLitry = (EditText) findViewById(R.id.editText11);
        spalanie.addTextChangedListener(tw);
        spaloneLitry.addTextChangedListener(tw);

    }
        public ObliczPrzejechaneKilometry(){
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
                spalanie1=Double.parseDouble(spalanie.getText()+"");
                spaloneLitry1=Double.parseDouble(spaloneLitry.getText()+"");
                Double wynik1=spaloneLitry1/spalanie1;
                java.text.DecimalFormat df = new java.text.DecimalFormat();
                df.setMaximumFractionDigits(2);
                df.setMinimumFractionDigits(2);
                String wynik2 = (df.format(wynik1));
                wynik.setText(wynik2);
                return;
            }catch(Exception var2_5){
                wynik.setText("0.0");
                return;
            }
            }
        };
    }
}
