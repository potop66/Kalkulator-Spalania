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


public class MainActivity5 extends ActionBarActivity {
      TextView wynik;
    EditText spalanie,spaloneLitry;
    Double spalanie1,spaloneLitry1,wynik1,wynik3;
            String  wynik2, spalanie2,spaloneLitry2;
    int a=0;
    Button oblicz;

    public void PobieranieDanych(){
        try {
           spalanie2 = spalanie.getText() + "";
            spaloneLitry2 = spaloneLitry.getText() + "";
            spalanie1 = Double.parseDouble(spalanie2);
            spaloneLitry1 = Double.parseDouble(spaloneLitry2);
            a=1;
        }catch (Exception var2_5){
            wynik.setText("0.0");
            a=0;
        }
    }
    public void Obliczenia(){
        if (a==1) {
            wynik.setText("0.0");
            wynik1 = spaloneLitry1/spalanie1;
            wynik3=wynik1*100;
            java.text.DecimalFormat df = new java.text.DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            wynik2 = (df.format(wynik3));
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
        setContentView(R.layout.activity_main_activity5);
        spalanie=(EditText) findViewById (R.id.editText9);
        spaloneLitry=(EditText) findViewById(R.id.editText8);
        oblicz=(Button) findViewById(R.id.button4);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity5, menu);
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
