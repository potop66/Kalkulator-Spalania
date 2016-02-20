package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class ObliczSpalanieNa100km extends ActionBarActivity {
    TextView wynik;
    EditText spalanie,dystans;
    float spalanie1 ,dystans1,wynik1;
    String spalanie2, dystans2,wynik2;
    TextWatcher tw;

    public ObliczSpalanieNa100km() {
        tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                try {
                    spalanie2 = spalanie.getText() + "";
                    dystans2 = dystans.getText() + "";
                    dystans1 = Float.parseFloat(dystans2);
                    spalanie1 = Float.parseFloat(spalanie2);
                    wynik.setText(R.string.wrongScore);
                    wynik1 = spalanie1 / dystans1 * 100;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                } catch (Exception var2_6) {
                    wynik.setText(R.string.wrongScore);
                }
            }
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);
        spalanie=(EditText) findViewById (R.id.editText6);
        dystans=(EditText) findViewById (R.id.editText7);
        wynik=(TextView) findViewById (R.id.textView13);


        SharedPreferences sp=getSharedPreferences("Settings",MODE_PRIVATE);
        TextView iloscSpalonejBenzyny=(TextView) findViewById(R.id.textView10);

        switch (sp.getInt("pojemnosc",0)){
            case 1:
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);
                break;
            case 2:
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);
                break;
        }
        if(sp.getInt("dystans",0)==1){
            TextView dystansTV=(TextView) findViewById(R.id.textView11);
            dystansTV.setText(R.string.iloscPrzejechanychMil);
            dystans.setHint(R.string.przejechaneMile);
        }

        spalanie.addTextChangedListener(tw);
        dystans.addTextChangedListener(tw);

    }
}
