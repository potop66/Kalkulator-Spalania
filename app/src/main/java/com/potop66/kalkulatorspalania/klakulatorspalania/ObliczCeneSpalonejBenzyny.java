package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class ObliczCeneSpalonejBenzyny extends ActionBarActivity {
    TextView wynik;
    EditText odleglosc, cena, spalanie;
    Double odleglosc1, cena1, spalanie1, wynik1, wynik2;
    String odleglosc2, cena2, spalanie2, wynik3;
    TextWatcher tw;
    int x = 1;// zmienna ktora wymnaza wszystkie zmiany zachodzace z powodu zamiany km na mile i litrow na gale


    public ObliczCeneSpalonejBenzyny() {
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
        wynik = (TextView) findViewById(R.id.textView5);
        odleglosc = (EditText) findViewById(R.id.editText);
        cena = (EditText) findViewById(R.id.editText2);
        spalanie = (EditText) findViewById(R.id.editText3);
        SharedPreferences sp = getSharedPreferences("Settings", MODE_PRIVATE);

        if (sp.getInt("dystans", 0) == 1 && sp.getInt("pojemnosc", 0) != 0) {
            TextView dystans = (TextView) findViewById(R.id.textView);
            TextView srednieSpalanie = (TextView) findViewById(R.id.textView3);
            odleglosc.setHint("Odleglosc w milach");
            dystans.setText(R.string.przejechaneMile);
            if (sp.getInt("pojemnosc", 0) == 1) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Mil);
            } else {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Mil);

            }
        } else if (sp.getInt("dystans", 0) == 1) {
            TextView dystans = (TextView) findViewById(R.id.textView);
            TextView srednieSpalanie = (TextView) findViewById(R.id.textView3);

            odleglosc.setHint("Odleglosc w milach");
            dystans.setText(R.string.przejechaneMile);
            srednieSpalanie.setText(R.string.liczbaSpalonychLitrowNa100Mil);

        } else if (sp.getInt("pojemnosc", 0) != 0) {
            TextView srednieSpalanie = (TextView) findViewById(R.id.textView3);
            if (sp.getInt("pojemnosc", 0) == 1) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Km);

            } else if (sp.getInt("pojemnosc", 0) == 2) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Km);

            }
            odleglosc.addTextChangedListener(tw);
            cena.addTextChangedListener(tw);
            spalanie.addTextChangedListener(tw);
        }
    }
}
