package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.content.Context.MODE_PRIVATE;


public class AmountOfBoughtFuelFragment extends android.app.Fragment {
    TextView wynik;
    EditText kwota, cena;
    String kwota2, cena2, wynik2;
    float kwota1, cena1, wynik1;
    TextWatcher tw;
    private AdView mAdView;


    public AmountOfBoughtFuelFragment() {
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
                    kwota2 = kwota.getText() + "";
                    cena2 = cena.getText() + "";
                    kwota1 = Float.parseFloat(kwota2);
                    cena1 = Float.parseFloat(cena2);
                    wynik.setText(R.string.wrongScore);
                    wynik1 = kwota1 / cena1;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                    return;
                } catch (Exception var2_6) {
                    wynik.setText(R.string.wrongScore);
                    return;
                }
            }
        };
    }

    public void ad(View view) {
        mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amount_of_bought_fuel, container, false);
        ad(view);
        kwota = (EditText) view.findViewById(R.id.editText4);
        cena = (EditText) view.findViewById(R.id.editText5);
        wynik = (TextView) view.findViewById(R.id.textView9);
        SharedPreferences sp = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        TextView iloscSpalanejBenzyny = (TextView) view.findViewById(R.id.textView8);
        switch (sp.getInt("pojemnosc", 0)) {
            case 1:
                iloscSpalanejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);
                break;
            case 2:
                iloscSpalanejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);
                break;
        }
        kwota.addTextChangedListener(tw);
        cena.addTextChangedListener(tw);


        return view;
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


}


