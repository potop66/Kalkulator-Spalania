package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ListView ListView;
    TextView a;
    String title[] = new String[]{"Oblicz  spalanie na 100 km", "Oblicz koszt spalonej benzyny",
            "Oblicz ilość spalonej benzyny "};
    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView = (ListView) findViewById(R.id.listView);
         a=(TextView) findViewById(R.id.textView14);
        final Context context = this;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_main, R.id.textView14, title);
        ListView.setAdapter(adapter);
        ListView.setOnItemClickListener(( AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;

                switch (itemPosition) {
                    case 0:
                            Intent i = new Intent(context, MainActivity4.class);
                            startActivity(i);

                        break;

                    case 1:
                        Intent c = new Intent(context, MainActivity2.class);
                        startActivity(c);
                        break;

                    case 2:
                        Intent b = new Intent(context, MainActivity3.class);
                        startActivity(b);
                        break;
               case 3:
                        Intent d =new Intent(context,MainActivity5.class);
                        startActivity(d);
                        break;


                }
            }

        });


    }
}