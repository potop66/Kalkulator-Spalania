package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import static java.lang.String.format;


public class MainActivity2 extends ActionBarActivity {
    TextView wynik;
    EditText odleglosc,cena,spalanie ;
    Double odleglosc1,cena1,spalanie1,wynik1,wynik2;
    String odleglosc2,cena2,spalanie2,wynik3;
    int a=0;

    public void PobieranieDanych(){
            try {
                odleglosc2 = odleglosc.getText() + "";
                cena2 = cena.getText() + "";
                spalanie2 = spalanie.getText() + "";
                odleglosc1 = Double.parseDouble(odleglosc2);
                cena1 = Double.parseDouble(cena2);
                spalanie1 = Double.parseDouble(spalanie2);
                a=1;
            } catch (Exception var2_6) {
                wynik.setText("0.0");
                a=0;
            }


    }
    public void Obliczenia(){
        if (a==1) {

            wynik1 = odleglosc1 / 100;
            wynik2 = wynik1 * cena1 * spalanie1;
            java.text.DecimalFormat df = new java.text.DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            wynik3 = (df.format(wynik2));
            wynik.setText(wynik3);
        }else {
            wynik.setText("0.0");
        }
    }

    public void Oblicz(View v){
        PobieranieDanych ();
        Obliczenia();
    }
    @Override
    public void onBackPressed (){
        Intent i= new Intent(this, MainActivity.class);
        startActivity (i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        wynik=(TextView) findViewById(R.id.textView5);
        odleglosc =(EditText) findViewById (R.id.editText);
        cena=(EditText) findViewById (R.id.editText2);
        spalanie=(EditText) findViewById (R.id.editText3);
        Button oblicz= (Button) findViewById (R.id.button);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
