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


public class MainActivity3 extends ActionBarActivity {
     TextView wynik;
    EditText kwota,cena;
    String kwota2, cena2,wynik2;
    float kwota1,cena1,wynik1;
    int a=0;

    public void PobieranieDanych(){
        try {
            kwota2 = kwota.getText() + "";
            cena2 = cena.getText() + "";
            kwota1 = Float.parseFloat(kwota2);
            cena1 = Float.parseFloat(cena2);
            a=1;
        }catch (Exception var2_6){
            wynik.setText("0.0");
            a=0;
        }
    }
    public void Obliczenia(){
        if (a==1) {
            wynik.setText("0.0");
            wynik1 = kwota1 / cena1;
            java.text.DecimalFormat df = new java.text.DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            wynik2 = (df.format(wynik1));
            wynik.setText(wynik2);
        }else{
            wynik.setText("0.0");
        }
    }
    @Override
    public void onBackPressed (){
        Intent i= new Intent(this, MainActivity.class);
        startActivity (i);
    }
    public void Oblicz(View v){
        PobieranieDanych();
        Obliczenia();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        kwota=(EditText) findViewById (R.id.editText4);
        cena=(EditText) findViewById (R.id.editText5);
        wynik=(TextView) findViewById (R.id.textView9);
        Button oblicz= (Button) findViewById(R.id.button2);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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
