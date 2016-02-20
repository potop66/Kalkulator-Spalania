package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Settings extends ActionBarActivity {
    Context context=this;
    String [] dystans_spinner_content;
    String [] pojemnosc_spinner_content;
    SharedPreferences.Editor editor;
    public void setArrays(){
        Resources res = getResources();
        dystans_spinner_content= res.getStringArray(R.array.dystans);
        pojemnosc_spinner_content= res.getStringArray(R.array.pojemnosc);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Spinner dystans =(Spinner) findViewById(R.id.spinner);
        Spinner pojemnosc =(Spinner) findViewById(R.id.spinner2);
        setArrays();

        SharedPreferences sharedPreferences=getSharedPreferences("Settings",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        dystans.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, dystans_spinner_content));
        dystans.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                editor.putInt("dystans",position1);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pojemnosc.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, pojemnosc_spinner_content));
        pojemnosc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                editor.putInt("pojemnosc",position1);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
