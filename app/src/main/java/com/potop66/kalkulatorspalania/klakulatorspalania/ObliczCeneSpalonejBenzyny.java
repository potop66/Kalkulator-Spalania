package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class ObliczCeneSpalonejBenzyny extends ActionBarActivity {
    TextView wynik;
    EditText odleglosc,cena,spalanie ;
    Double odleglosc1,cena1,spalanie1,wynik1,wynik2;
    String odleglosc2,cena2,spalanie2,wynik3;
    TextWatcher tw;

    public ObliczCeneSpalonejBenzyny(){
        tw=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    odleglosc2 = odleglosc.getText() + "";
                    cena2 = cena.getText() + "";
                    spalanie2 = spalanie.getText() + "";
                    odleglosc1 = Double.parseDouble(odleglosc2);
                    cena1 = Double.parseDouble(cena2);
                    spalanie1 = Double.parseDouble(spalanie2);

                    wynik1 = odleglosc1 / 100;
                    wynik2 = wynik1 * cena1 * spalanie1;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    wynik3 = (df.format(wynik2));
                    wynik.setText(wynik3);
                    return;
                } catch (Exception var2_6) {
                    wynik.setText(R.string.wrongScore);
                    return;
                }
            }
        };
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        wynik=(TextView) findViewById(R.id.textView5);
        odleglosc =(EditText) findViewById (R.id.editText);
        cena=(EditText) findViewById (R.id.editText2);
        spalanie=(EditText) findViewById (R.id.editText3);

        odleglosc.addTextChangedListener(tw);
        cena.addTextChangedListener(tw);
        spalanie.addTextChangedListener(tw);
    }
}
