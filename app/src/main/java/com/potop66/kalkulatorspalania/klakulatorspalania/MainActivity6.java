package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity6 extends ActionBarActivity {
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
        public MainActivity6(){
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity6, menu);
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
