package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity4 extends ActionBarActivity {
    TextView wynik;
    EditText spalanie,dystans;
    float spalanie1 ,dystans1,wynik1;
    String spalanie2, dystans2,wynik2;
    int a=0;

    public void PobieranieDanych(){
        try {
            spalanie2 = spalanie.getText() + "";
            dystans2 = dystans.getText() + "";
            dystans1 = Float.parseFloat(dystans2);
            spalanie1 = Float.parseFloat(spalanie2);
            a=1;
        }catch (Exception var2_6){
            wynik.setText("0.0");
            a=0;
        }
    }
    public void Obliczenia() {
        if (a == 1) {
            wynik.setText("0.0");
            wynik1 = spalanie1 / dystans1 * 100;
            java.text.DecimalFormat df = new java.text.DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            wynik2 = (df.format(wynik1));
            wynik.setText(wynik2);
        }else {
            wynik.setText("0.0");

        }
    }
    public void Oblicz(View v){
        PobieranieDanych();
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
        setContentView(R.layout.activity_main_activity4);
        spalanie=(EditText) findViewById (R.id.editText6);
        dystans=(EditText) findViewById (R.id.editText7);
        wynik=(TextView) findViewById (R.id.textView13);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
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
